package com.android.game.rania.model;

import com.android.game.rania.model.element.DynamicObject;
import com.android.game.rania.model.element.ObjectID;

public class SpaceShip extends DynamicObject{
	
	public SpaceShip(float posX, float posY){
		super(ObjectID.SHIP, posX, posY);
	}
	
	public SpaceShip(float posX, float posY, float rotAngle){
		super(ObjectID.SHIP, posX, posY, rotAngle);
	}
	
	public SpaceShip(float posX, float posY, float rotAngle, float scaleX, float scaleY){
		super(ObjectID.SHIP, posX, posY, rotAngle, scaleX, scaleY);
	}
}
