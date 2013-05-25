package com.android.game.rania.model.element;

public class HUDObject extends Object{

	public HUDObject(ObjectID id, float posX, float posY, float rotAngle, float scaleX, float scaleY) {
		super(id, posX, posY, rotAngle, scaleX, scaleY);
	}

	public HUDObject(ObjectID id, float posX, float posY, float rotAngle){
		super(id, posX, posY, rotAngle, 1.0f, 1.0f);
	}
	
	public HUDObject(ObjectID id, float posX, float posY){
		super(id, posX, posY, 0.0f, 1.0f, 1.0f);
	}
	
	public HUDObject asHUDObject(){
		return this;
	}
}
