package com.android.game.rania.screen;

import com.android.game.rania.RaniaGame;
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
	
	private MainView view = null;
	private MainController controller = null;
	private Texture texture = null;
	private Texture textureBackground = null;
	
	public SpaceScreen(){
		view = RaniaGame.mView;
		controller = RaniaGame.mController;
	}

	@Override
	public void show() {
		texture  = new Texture(Gdx.files.internal("data/sprites/SpaceShip.png"));
		view.setTextureRegion(texture, ObjectID.SHIP);
		textureBackground = new Texture(Gdx.files.internal("data/backgrounds/background.jpg"));
		view.setTextureRegion(textureBackground, ObjectID.BACKGROUND);
		
		controller.AddDynamicObject(new SpaceShip(0.0f, 0.0f));
		controller.AddStaticObjects(new StaticObject(0.0f, 0.0f, ObjectID.BACKGROUND));
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

		controller.update();
		view.draw(controller.getDynamicObjects(), controller.getStaticObjects());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}
}
