package com.android.game.rania.userdata;

import java.net.Socket;
import java.util.List;

public class User {
	public String login;
	public Socket socket;
	public boolean isConnected;
	public boolean isLogin;
	public Thread receiver;
	public List<Command> commands;
}
