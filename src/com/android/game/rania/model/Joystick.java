package com.android.game.rania.model;

import com.android.game.rania.model.element.Group;
import com.android.game.rania.model.element.Object;
import com.android.game.rania.model.element.HUDObject;
import com.android.game.rania.model.element.ObjectID;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class Joystick extends Group implements InputProcessor{

	private Object	  controllObject = null;
	private HUDObject background 	 = null;
	private HUDObject dragger 	 	 = null;
	private float 	  radius 	 	 = 0.0f;
	
	public Joystick(float x, float y, float touchRadius, Object object) {
		super();
		radius = touchRadius;
		controllObject = object;
		
		background = new HUDObject(ObjectID.JOYSTICK, x, y);
		dragger    = new HUDObject(ObjectID.JOYSTICK_UP, x, y);
		
		AddElement(background);
		AddElement(dragger);
	}

	//contoller
	private boolean touch 	  = false;
	private Vector2	bufferVec = new Vector2(0, 0);
	private Vector2	delta 	  = new Vector2(0, 0);
		
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		bufferVec.set(background.position);
		bufferVec.sub(x, Gdx.graphics.getHeight() - y);
		touch = (bufferVec.len() <= radius);
		return touch;
	}
	
	public void update(float deltaTime) {
		if (!touch)
			return;

		bufferVec.set(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
		bufferVec.sub(background.position);
		if (bufferVec.len() > radius){
			bufferVec.nor();
			bufferVec.mul(radius);
			bufferVec.add(background.position);
		}
		dragger.position.set(bufferVec);
		delta.set(background.position);
		delta.sub(dragger.position);
		delta.nor();
		//delta.mul(deltaTime);
		controllObject.position.sub(delta);
		controllObject.angle = (float)Math.toDegrees(Math.atan2(delta.x, -delta.y));
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if (!touch)
			return false;

		dragger.position.set(background.position);
		touch = false;
		return true;
	}

	@Override
	public boolean keyDown(int keyCode) {
		return false;
	}

	@Override
	public boolean keyTyped(char keyCode) {
		return false;
	}

	@Override
	public boolean keyUp(int keyCode) {
		return false;
	}

	@Override
	public boolean mouseMoved(int x, int y) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return false;
	}
}
