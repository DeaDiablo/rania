package com.android.game.rania.screen;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.controller.MainController;
import com.android.game.rania.controller.ShipController;
import com.android.game.rania.model.ParallaxLayer;
import com.android.game.rania.model.SpaceShip;
import com.android.game.rania.model.element.RegionID;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class SpaceScreen implements Screen{
	
	private MainView view = null;
	private MainController controller = null;
	
	public SpaceScreen(){
		view = RaniaGame.mView;
		controller = RaniaGame.mController;
	}

	@Override
	public void show() {
		view.loadTexture("data/sprites/SpaceShip.png", RegionID.SHIP);
		view.loadTexture("data/backgrounds/space.jpg", RegionID.BACKGROUND_SPACE);
		view.getTexture(RegionID.BACKGROUND_SPACE).setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		view.loadTexture("data/backgrounds/stars.png", RegionID.BACKGROUND_STARS);
		view.getTexture(RegionID.BACKGROUND_STARS).setWrap(TextureWrap.Repeat, TextureWrap.Repeat);

		SpaceShip ship = new SpaceShip(0.0f, 0.0f);
		controller.setPlayer(ship);

		controller.addStaticObject(new ParallaxLayer(RegionID.BACKGROUND_SPACE, 0.5f, 1.0f));
		controller.addStaticObject(new ParallaxLayer(RegionID.BACKGROUND_STARS, 0.2f, 1.0f));
		controller.addProcessor(new ShipController(ship));
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		controller.clear();
		view.clear();
	}

	@Override
	public void pause() {
	}

	@Override
	public void render(float deltaTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		controller.update(deltaTime);
		view.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
	}
}
