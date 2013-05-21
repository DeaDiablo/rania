package com.android.game.rania;

import com.android.game.rania.screens.SpaceScreen;
import com.badlogic.gdx.Game;

public class RaniaGame extends Game {

	@Override
	public void create() {
		setScreen(new SpaceScreen());
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
