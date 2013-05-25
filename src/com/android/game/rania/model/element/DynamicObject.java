package com.android.game.rania.model.element;

public class DynamicObject extends Object{

	public DynamicObject(ObjectID id, float posX, float posY, float rotAngle, float scaleX, float scaleY){
		super(id, posX, posY, rotAngle, scaleX, scaleY);
	}

	public DynamicObject(ObjectID id, float posX, float posY, float rotAngle){
		super(id, posX, posY, rotAngle, 1.0f, 1.0f);
	}
	
	public DynamicObject(ObjectID id, float posX, float posY){
		super(id, posX, posY, 0.0f, 1.0f, 1.0f);
	}
	
	@Override
	public DynamicObject asDynamicObject(){
		return this;
	}
}
