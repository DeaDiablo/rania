package com.android.game.rania.model;

import com.badlogic.gdx.math.Vector2;

public class Object {

	private Vector2  position = new Vector2(0.0f, 0.0f);
	private ObjectID idObject = ObjectID.NONE;

	public Object(float x, float y, ObjectID id){
		position.x = x;
		position.y = y;
		idObject = id;
	}

	//get position
	public Vector2 getPosition(){
		return position;
	}
	public float getPositionX(){
		return position.x;
	}
	public float getPositionY(){
		return position.y;
	}
	//set position
	public void setPositionX(Vector2 pos){
		position = pos;
	}
	public void setPositionY(float x, float y){
		position.x = x;
		position.y = y;
	}

	//objectID
	public ObjectID getObjectID(){
		return idObject;
	}
	public void setObjectID(ObjectID id){
		idObject = id;
	}
}
