package com.android.game.rania.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class SpaceScreen implements Screen{

	//camera
	private OrthographicCamera camera = null;
	private final float heightSize = 384.0f;

	@Override
	public void show() {
		//create camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, heightSize * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), heightSize);
		camera.update();
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void render(float deltaTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}
}
