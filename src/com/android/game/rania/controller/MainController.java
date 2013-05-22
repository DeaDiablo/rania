package com.android.game.rania.controller;

import java.util.Vector;

import com.android.game.rania.model.Model;
import com.android.game.rania.model.SpaceShip;

public class MainController {

	private Vector<Model> models = new Vector<Model>();

	public MainController(){
	}
	
	public Vector<Model> getModels(){
		return models;
	}
	
	public void AddModelSpaceShip(float x, float y){
		models.add(new SpaceShip(x, y));
	}
	
	public void update(){
	}
}
