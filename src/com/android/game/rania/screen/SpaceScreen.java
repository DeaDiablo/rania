package com.android.game.rania.screen;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.model.Model;
import com.android.game.view.MainView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;

public class SpaceScreen implements Screen{
	
	private MainView mView = null;
	private MainController mController = null;
	
	public SpaceScreen(MainView view, MainController contoller){
		mView = view;
		mController = contoller;
	}

	@Override
	public void show() {
		Texture texture  = new Texture(Gdx.files.internal("data/sprites/SpaceShip.png"));
		mView.setTextureRegion(texture, Model.ModelID.SHIP);
		
		mController.AddModelSpaceShip(0.0f, 0.0f);
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

		mController.update();
		mView.draw(mController.getModels());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}
}
