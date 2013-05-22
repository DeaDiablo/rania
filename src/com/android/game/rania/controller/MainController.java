package com.android.game.rania.controller;

import java.util.Vector;

import com.android.game.rania.model.DynamicObject;
import com.android.game.rania.model.StaticObject;

public class MainController {

	private Vector<DynamicObject> dynamicObjects = new Vector<DynamicObject>();
	private Vector<StaticObject> staticObjects = new Vector<StaticObject>();

	public MainController(){
	}
	
	public Vector<DynamicObject> getDynamicObjects(){
		return dynamicObjects;
	}

	public Vector<StaticObject> getStaticObjects(){
		return staticObjects;
	}
	
	public void AddDynamicObject(DynamicObject object){
		dynamicObjects.add(object);
	}
	
	public void AddStaticObjects(StaticObject object){
		staticObjects.add(object);
	}
	
	public void update(){
	}
}
