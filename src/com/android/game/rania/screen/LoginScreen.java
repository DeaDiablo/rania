package com.android.game.rania.screen;

import com.android.game.rania.utils.LoginListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class LoginScreen implements Screen{

	LoginListener listener = null;
	@Override
	public void show() {
		listener = new LoginListener();
		Gdx.input.getTextInput(listener, "Login", "");
	}

	@Override
	public void dispose() {		
	}

	@Override
	public void hide() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void render(float deltaTime) {
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {		
	}
}
