package com.android.game.rania.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.http.util.EncodingUtils;
import com.android.game.rania.RaniaGame;
import com.android.game.rania.userdata.Command;
import com.android.game.rania.userdata.User;

public class NetController {
	
	private int serverPort = 7777;
	private String serverAddress = "92.255.251.88";

	public User ClientLogin(String Login)
	{
		User Res = new User();
		Res.login = Login;
		Res.socket = null;
		Res.isLogin = false;
    	Res.isConnected = false;
		try
		{
			InetAddress ipAddress = InetAddress.getByName(serverAddress);
			Socket socket = new Socket(ipAddress, serverPort);
			if (socket.isConnected())
			{
				Res.socket = socket;
				InputStream sin = socket.getInputStream();
	            OutputStream sout = socket.getOutputStream();
	            DataInputStream in = new DataInputStream(sin);
	            DataOutputStream out = new DataOutputStream(sout);
	            out.write(intToByteArray(1));
	            byte[] data = EncodingUtils.getBytes(Login, "UTF-16");
	            out.write(intToByteArray(data.length));
	            out.write(data);
	            out.flush();
	            byte[] answer = new byte[4]; 
	            in.read(answer);
	            if (byteArrayToInt(answer) == 2) 
	            {
	            	Res.receiver = new ReceiverWork();
	            	Res.commands = new ArrayList<Command>();
	            	Res.isLogin = true;
	            	Res.isConnected = true;
	            	Res.receiver.start();
	            }
			}
		}
		catch (Exception ex)
		{
		}
		return Res;
	}
	private class ReceiverWork extends Thread
	{
	    public void run()
	    {
	    	try
	        {
				InputStream sin = RaniaGame.mUser.socket.getInputStream();
				//OutputStream sout = RaniaGame.mUser.socket.getOutputStream();
				DataInputStream in = new DataInputStream(sin);
				//DataOutputStream out = new DataOutputStream(sout);
				byte[] bytesCom = new byte[4];
				byte[] bytesLen = new byte[4];
				int Command = 0;
				int Length = 0;
				byte[] data;
				while (true)
				{
	            
	            		in.read(bytesCom);
	            		in.read(bytesLen);
	            		Command = byteArrayToInt(bytesCom);
	            		Length = byteArrayToInt(bytesLen);
	            		data = new byte[Length];
	            		if (Command == 4)
	            		{
	            			in.read(data);
	            			RaniaGame.mUser.commands.add(new Command(Command, Length, data));
	            			//String MessageTxt = EncodingUtils.getString(data, "UTF-16");
	            			//AddMessage(TextBox, MessageTxt);  
	            		}
	            
				}
	        }
	        catch (Exception ex)
	        {

	        }
	    }
	}
	public void Disconnect(User user)
	{
		try
		{
			OutputStream sout = user.socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(sout);
			out.write(intToByteArray(5));
			out.write(intToByteArray(0));
            out.flush();
			user.socket.shutdownInput();
			user.socket.shutdownOutput();
			user.socket.close();
		}
		catch (Exception ex)
		{
		}
	}
	
	public void SendMessage(User user, String Message)
	{
		try
        {
			//InputStream sin = RaniaGame.mUser.socket.getInputStream();
			OutputStream sout = RaniaGame.mUser.socket.getOutputStream();
			//DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);
			out.write(intToByteArray(4)); // Команда:Message
            byte[] data = EncodingUtils.getBytes(Message, "UTF-16");
            out.write(intToByteArray(data.length));
            out.write(data);
        }
        catch (Exception ex)
        {
        }
	}
	public static int byteArrayToInt(byte[] b)
    {
        return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a)
    {
        return new byte[] { (byte)((a >> 24) & 0xFF), (byte)((a >> 16) & 0xFF), (byte)((a >> 8) & 0xFF), (byte)(a & 0xFF) };
    }
}
