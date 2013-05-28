package com.android.game.rania.userdata;

import java.net.Socket;
import java.util.List;


public class User {
	public String login;
	public Socket socket;
	public Thread receiver;
	public boolean isConnected;
	public boolean isLogin;
	public List<Command> commands;
}
