package com.android.game.rania.net;

//import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.badlogic.gdx.Gdx;

public class NetController {
	
	private int serverPort = 7777;
	private String serverAddress = "92.255.251.88";
	
    public boolean ClientLogin(String Login)
	{
		boolean Res = false;
		try
		{
			InetAddress ipAddress = InetAddress.getByName(serverAddress);
			Socket socket = new Socket(ipAddress, serverPort);
			if (socket.isConnected())
			{
				//InputStream sin = socket.getInputStream();
	            OutputStream sout = socket.getOutputStream();
	            ////DataInputStream in = new DataInputStream(sin);
	            DataOutputStream out = new DataOutputStream(sout);
	            String LogStr = "<Login>|"+Login;
	            out.writeBytes(LogStr);
	            out.flush();
				Res = true;
			}
		}
		catch (Exception ex)
		{
			Res = false;
		}
		return Res;
	}
}
