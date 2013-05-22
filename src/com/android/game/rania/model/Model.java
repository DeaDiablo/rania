package com.android.game.rania.model;

import com.badlogic.gdx.math.Vector2;

public class Model {
	
	public enum ModelID{
		NONE,
		SHIP
	}
	
	private Vector2 position = new Vector2(0.0f, 0.0f);
	private String  name 	= "";
	private ModelID	idModel = ModelID.NONE;

	public Model(String objectName, float x, float y, ModelID id){
		name = objectName;
		position.x = x;
		position.y = y;
		idModel = id;
	}

	//name
	public String getName(){
		return name;
	}
	public void setName(String objectName){
		name = objectName;
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
	public ModelID getObjectID(){
		return idModel;
	}
}
