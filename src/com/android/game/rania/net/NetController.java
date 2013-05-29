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

	public User ClientLogin(String Login, String Password)
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
				DataInputStream in = new DataInputStream(sin);
				SendCommand(1, EncodingUtils.getBytes(Login, "UTF-16"), socket);
				SendCommand(6, EncodingUtils.getBytes(Password, "UTF-16"), socket);
				byte[] answer = new byte[4]; 
				in.read(answer);
				if (byteArrayToInt(answer) == 2) 
				{
					Res.socket = socket;
					Res.isLogin = true;
					Res.isConnected = true;
					Res.receiver = new ReceiverWork();
					Res.commands = new ArrayList<Command>();
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
					DataInputStream in = new DataInputStream(sin);
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
						}
					}
				}
				catch (Exception ex)
				{
	
				}
			}
		}
	public void ClientDisconnect(User user)
	{
		try
		{
			SendCommand(5, new byte[0], user.socket);
			user.socket.shutdownInput();
			user.socket.shutdownOutput();
			user.socket.close();
		}
		catch (Exception ex)
		{
			
		}
	}
	public void ClientRelogin(User user)
	{
		
	}
	public void GetUserData(User user)
	{
		try
		{
			
		}
		catch (Exception ex)
		{
			ClientRelogin(user);
		}
	}
	public void SendCommand(int cmd, byte[] data, Socket socket)
	{
		try 
		{
			OutputStream sout = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(sout);
			out.write(intToByteArray(cmd));
			out.write(intToByteArray(data.length));
			out.write(data);
			out.flush();
		} 
		catch (Exception ex) {
			
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
