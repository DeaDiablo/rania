package com.android.game.rania.utils;

import com.badlogic.gdx.Input.TextInputListener;
import com.android.game.rania.RaniaGame;
import com.android.game.rania.net.NetController;
import com.android.game.rania.screen.SpaceScreen;

public class LoginListener implements TextInputListener {

	@Override
	public void input (String text) {
		NetController netController = new NetController();
		RaniaGame.mUser = netController.ClientLogin(text);
		if (RaniaGame.mUser.isLogin)
			RaniaGame.mGame.setScreen(new SpaceScreen());
		else
			canceled();
	}

	@Override
	public void canceled () {
		RaniaGame.mGame.dispose();
	}

}
