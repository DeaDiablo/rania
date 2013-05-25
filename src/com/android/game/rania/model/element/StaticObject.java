package com.android.game.rania.model.element;

public class StaticObject extends Object{

	public StaticObject(ObjectID id, float posX, float posY, float rotAngle, float scaleX, float scaleY){
		super(id, posX, posY, rotAngle, scaleX, scaleY);
	}

	public StaticObject(ObjectID id, float posX, float posY, float rotAngle){
		super(id, posX, posY, rotAngle, 1.0f, 1.0f);
	}
	
	public StaticObject(ObjectID id, float posX, float posY){
		super(id, posX, posY, 0.0f, 1.0f, 1.0f);
	}
	
	@Override
	public StaticObject asStaticObject(){
		return this;
	}
}
