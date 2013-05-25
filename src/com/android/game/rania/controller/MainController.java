package com.android.game.rania.controller;

import java.util.Vector;

import com.android.game.rania.model.element.DynamicObject;
import com.android.game.rania.model.element.Group;
import com.android.game.rania.model.element.HUDObject;
import com.android.game.rania.model.element.Object;
import com.android.game.rania.model.element.StaticObject;

public class MainController{

	private Vector<DynamicObject> dynamicObjects = new Vector<DynamicObject>();
	private Vector<StaticObject> staticObjects = new Vector<StaticObject>();
	private Vector<HUDObject> HUDObjects = new Vector<HUDObject>();
	private DynamicObject mPlayer = null;

	public MainController(){
	}
	
	public DynamicObject getPlayer(){
		return mPlayer;
	}
	
	public void setPlayer(DynamicObject player)
	{
		mPlayer = player;
	}
	
	public Vector<DynamicObject> getDynamicObjects(){
		return dynamicObjects;
	}
	
	public void addDynamicObject(DynamicObject object){
		dynamicObjects.add(object);
	}

	public Vector<StaticObject> getStaticObjects(){
		return staticObjects;
	}
	
	public void addStaticObject(StaticObject object){
		staticObjects.add(object);
	}
	
	public Vector<HUDObject> getHUDObjects(){
		return HUDObjects;
	}
	
	public void addHUDObject(HUDObject object){
		HUDObjects.add(object);
	}
	
	public void addObject(Object object){
		if (object.asDynamicObject() != null) {
			dynamicObjects.add(object.asDynamicObject());
			return;
		}
		
		if (object.asStaticObject() != null) {
			staticObjects.add(object.asStaticObject());
			return;
		}
		
		if (object.asHUDObject() != null)
		{
			HUDObjects.add(object.asHUDObject());
			return;
		}
	}
	
	public void addObject(Group group){
		for(Object element : group.getElements()){
			addObject(element);
		}
	}
	
	public void update(float deltaTime){
	}

	public void clear() {
		dynamicObjects.clear();
		staticObjects.clear();
		HUDObjects.clear();
		mPlayer = null;
	}
}
