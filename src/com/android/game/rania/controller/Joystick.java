package com.android.game.rania.controller;

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
	
	//Sets the position of the joystick, depending on what the device supports
	//check : RaniaGame.mContext.getPackageManager().hasSystemFeature
	//param : PackageManager.FEATURE_TOUCHSCREEN, The device’s display has a touch screen.
	//param : PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH, The device’s touch screen supports multitouch sufficient for basic two-finger gesture detection.
	//param : PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT, The device’s touch screen is capable of tracking two or more fingers fully independently.
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
	private int		pTouch	  = -1;
	private Vector2	bufferVec = new Vector2(0, 0);
	private Vector2	delta 	  = new Vector2(0, 0);

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (pTouch >= 0)
			return false;

		bufferVec.set(x, Gdx.graphics.getHeight() - y);
		bufferVec.sub(background.position);
		if (bufferVec.len() > radius)
			return false;

		pTouch = pointer;
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		if (pTouch != pointer)
			return false;
		
		bufferVec.set(x, Gdx.graphics.getHeight() - y);
		bufferVec.sub(background.position);
		return true;
	}
	
	public void update(float deltaTime) {
		if (pTouch < 0)
			return;

		if (bufferVec.len() > radius){
			bufferVec.nor();
			bufferVec.mul(radius);
		}

		dragger.position.set(background.position);
		dragger.position.add(bufferVec);

		delta.set(dragger.position);
		delta.sub(background.position);
		delta.nor();
		//delta.mul(deltaTime);
		controllObject.position.add(delta);
		controllObject.angle = (float)Math.toDegrees(Math.atan2(-delta.x, delta.y));
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if (pTouch != pointer)
			return false;
		dragger.position.set(background.position);
		pTouch = -1;
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
}
