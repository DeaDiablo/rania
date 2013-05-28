package com.android.game.rania.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
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
	            String LogStr = "<Login>|"+Login;
	            out.writeBytes(LogStr);
	            out.flush();
	            byte[] answer = new byte[1]; 
	            in.read(answer);
	            if (answer[0] == 1) 
	            {
	            	Res.socket = socket;
	            	Res.isLogin = true;
	            	Res.isConnected = true;
	            }
			}
		}
		catch (Exception ex)
		{
		}
		return Res;
	}
	public void ClientDisconnect(User user)
	{
		try
		{
			String DCMSG = "<End>";
			OutputStream sout = user.socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(sout);
            out.writeBytes(DCMSG);
            out.flush();
			user.socket.shutdownInput();
			user.socket.shutdownOutput();
			user.socket.close();
		}
		catch (Exception ex)
		{
		}
	}
}
