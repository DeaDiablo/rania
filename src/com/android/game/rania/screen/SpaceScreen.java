package com.android.game.rania.screen;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.controller.MainController;
import com.android.game.rania.controller.Joystick;
import com.android.game.rania.model.ParallaxLayer;
import com.android.game.rania.model.SpaceShip;
import com.android.game.rania.model.element.ObjectID;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class SpaceScreen implements Screen{
	
	private MainView view = null;
	private MainController controller = null;
	private Joystick joystick = null;
	
	public SpaceScreen(){
		view = RaniaGame.mView;
		controller = RaniaGame.mController;
	}

	@Override
	public void show() {
		view.loadTexture("data/sprites/SpaceShip.png", ObjectID.SHIP);
		view.loadTexture("data/backgrounds/space.jpg", ObjectID.BACKGROUND_SPACE);
		view.getTexture(ObjectID.BACKGROUND_SPACE).setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		view.loadTexture("data/backgrounds/stars.png", ObjectID.BACKGROUND_STARS);
		view.getTexture(ObjectID.BACKGROUND_STARS).setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		view.loadTexture("data/sprites/Joystick.png", ObjectID.JOYSTICK);
		view.loadTexture("data/sprites/JoystickUp.png", ObjectID.JOYSTICK_UP);
		

		controller.setPlayer(new SpaceShip(0.0f, 0.0f));
		joystick = new Joystick(view.getTexture(ObjectID.JOYSTICK).getWidth(), 
								view.getTexture(ObjectID.JOYSTICK).getHeight(),
								view.getTexture(ObjectID.JOYSTICK).getWidth() * 0.5f,
								controller.getPlayer());
		controller.addObject(joystick);
		controller.addStaticObject(new ParallaxLayer(ObjectID.BACKGROUND_SPACE, 0.5f, 1.0f));
		controller.addStaticObject(new ParallaxLayer(ObjectID.BACKGROUND_STARS, 0.2f, 1.0f));
		Gdx.input.setInputProcessor(joystick);
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

		joystick.update(deltaTime);
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
