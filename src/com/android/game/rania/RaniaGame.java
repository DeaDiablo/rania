package com.android.game.rania;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.net.NetController;
import com.android.game.rania.screen.MainMenu;
import com.android.game.rania.userdata.User;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class RaniaGame extends Game {
	
	public static RaniaGame      mGame       = null;
	public static MainView       mView       = null;
	public static MainController mController = null;
	public static NetController  nController = null;
	public static User           mUser       = null;
	@Override
	public void create() {
		mGame = this;
		mView = new MainView();
		mController = new MainController();
		mUser = new User();
		nController = new NetController();
		setScreen(new MainMenu());
	}

	/*
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void render() {

	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	*/

	@Override
	public void dispose() {
		Gdx.app.exit();
	}
}
