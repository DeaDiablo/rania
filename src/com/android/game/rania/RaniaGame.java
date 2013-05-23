package com.android.game.rania;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.screen.LoginScreen;
//import com.android.game.rania.screen.SpaceScreen;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class RaniaGame extends Game {
	
	public static RaniaGame      mGame       = null;
	public static MainView       mView       = null;
	public static MainController mController = null;

	@Override
	public void create() {
		mGame = this;
		mView = new MainView();
		mController = new MainController();
		//setScreen(new SpaceScreen());
		setScreen(new LoginScreen());
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
