package com.android.game.rania.utils;

import com.badlogic.gdx.Input.TextInputListener;
import com.android.game.rania.RaniaGame;
import com.android.game.rania.screen.SpaceScreen;

public class LoginListener implements TextInputListener {

	@Override
	public void input (String text) {
		RaniaGame.mUser = RaniaGame.nController.ClientLogin(text);
		if (RaniaGame.mUser.isLogin)
		{
			RaniaGame.mGame.setScreen(new SpaceScreen());
			RaniaGame.nController.SendMessage(RaniaGame.mUser, "Клиент залогинился удачно");
		}
		else
		{
			RaniaGame.nController.SendMessage(RaniaGame.mUser, "Клиент залогинился не очень удачно");
			canceled();
		}
	}

	@Override
	public void canceled () {
		RaniaGame.nController.Disconnect(RaniaGame.mUser);
		RaniaGame.mGame.dispose();
	}

}
