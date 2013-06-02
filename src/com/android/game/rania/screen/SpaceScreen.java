package com.android.game.rania.screen;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.controller.MainController;
import com.android.game.rania.controller.ShipController;
import com.android.game.rania.model.Location;
import com.android.game.rania.model.LocationSprite;
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
		view.loadTexture("data/sprites/star.png", RegionID.STAR);
		view.loadTexture("data/sprites/planet.png", RegionID.PLANET);
		view.loadTexture("data/sprites/SpaceShip.png", RegionID.SHIP);
		view.loadTexture("data/backgrounds/space.jpg", RegionID.BACKGROUND_SPACE);
		view.getTexture(RegionID.BACKGROUND_SPACE).setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		view.loadTexture("data/backgrounds/stars.png", RegionID.BACKGROUND_STARS);
		view.getTexture(RegionID.BACKGROUND_STARS).setWrap(TextureWrap.Repeat, TextureWrap.Repeat);

		SpaceShip ship = new SpaceShip(250.0f, 250.0f);
		controller.setPlayer(ship);

		controller.addStaticObject(new ParallaxLayer(RegionID.BACKGROUND_SPACE, 0.3f, 1.0f));
		controller.addStaticObject(new ParallaxLayer(RegionID.BACKGROUND_STARS, 0.0f, 1.0f));
		//Gdx.app.log("looog", "size: " + locations.size());
		Location loc = new Location();
		loc.id = 0;
		loc.x = 0;
		loc.y = 0;
		loc.starType = 0;
		loc.starName = "Sun";
		controller.addObject(new LocationSprite(loc));
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
