package com.android.game.rania.model;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.model.element.DynamicObject;
import com.android.game.rania.model.element.RegionID;

public class SpaceShip extends DynamicObject{
	
	public float speed = 1.0f;

	public SpaceShip(float posX, float posY){
		super(RaniaGame.mView.getTextureRegion(RegionID.SHIP), posX, posY);
	}
	
	public SpaceShip(float posX, float posY, float rotAngle){
		super(RaniaGame.mView.getTextureRegion(RegionID.SHIP), posX, posY, rotAngle);
	}
	
	public SpaceShip(float posX, float posY, float rotAngle, float scaleX, float scaleY){
		super(RaniaGame.mView.getTextureRegion(RegionID.SHIP), posX, posY, rotAngle, scaleX, scaleY);
	}
}
