package com.android.game.rania.screen;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.model.ObjectID;
import com.android.game.rania.model.SpaceShip;
import com.android.game.rania.model.StaticObject;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;

public class SpaceScreen implements Screen{
	
	private MainView mView = null;
	private MainController mController = null;
	private Texture texture = null;
	private Texture textureBackground = null;
	
	public SpaceScreen(MainView view, MainController contoller){
		mView = view;
		mController = contoller;
	}

	@Override
	public void show() {
		texture  = new Texture(Gdx.files.internal("data/sprites/SpaceShip.png"));
		mView.setTextureRegion(texture, ObjectID.SHIP);
		textureBackground = new Texture(Gdx.files.internal("data/backgrounds/background.jpg"));
		mView.setTextureRegion(textureBackground, ObjectID.BACKGROUND);
		
		mController.AddDynamicObject(new SpaceShip(0.0f, 0.0f));
		mController.AddStaticObjects(new StaticObject(0.0f, 0.0f, ObjectID.BACKGROUND));
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		if (texture != null)
			texture.dispose();
		if (textureBackground != null)
			textureBackground.dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void render(float deltaTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		mController.update();
		mView.draw(mController.getDynamicObjects(), mController.getStaticObjects());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}
}
