package com.android.game.rania;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.screen.SpaceScreen;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Game;

public class RaniaGame extends Game {
	
	private MainView mView = null;
	private MainController mController = null;

	@Override
	public void create() {
		mView = new MainView();
		mController = new MainController();
		setScreen(new SpaceScreen(mView, mController));
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

	@Override
	public void dispose() {
	
	}
	*/
}
