package com.android.game.rania.controller;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.model.SpaceShip;
import com.android.game.rania.userdata.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class ShipController extends UpdateController{
	
	private boolean move       = true;
	private boolean touched    = false;
	private Vector2 touchPoint = new Vector2(0, 0);
	private Vector2 moveVec    = new Vector2(0, 0);
	
	private SpaceShip controllObject = null;
	
	public ShipController(SpaceShip ship){
		controllObject = ship;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		touchPoint.set(x, Gdx.graphics.getHeight() - y);
		RaniaGame.mView.getCamera().toCameraCoord(touchPoint);
		RaniaGame.nController.SendTouchPoint((int)touchPoint.x, (int)touchPoint.y, RaniaGame.mUser);
		touched = true;
		move = true;
		return true;
	}

	@Override
	public void update(float deltaTime) {
		if (!move || controllObject == null)
			return;

		if (touched){
			moveVec.set(touchPoint);
			moveVec.sub(controllObject.position);
			moveVec.nor();
			moveVec.mul(controllObject.speed * deltaTime * 100);
			touched = false;
		}

		if (!touchPoint.epsilonEquals(controllObject.position, moveVec.len())){
			controllObject.position.add(moveVec);
			controllObject.angle = (float)Math.toDegrees(Math.atan2(-moveVec.x, moveVec.y));
		}
		else
		{
			moveVec.set(0.0f, 0.0f);
			controllObject.position.set(touchPoint);
			RaniaGame.nController.SendTouchPoint((int)touchPoint.x, (int)touchPoint.y, RaniaGame.mUser);
			move = false;
		}
	}
}
