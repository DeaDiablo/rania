package com.android.game.rania.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class Camera extends OrthographicCamera{

	private float dx = 0.0f;
	private float dy = 0.0f;
	
	public Camera(float height){
		super(height * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), height);
		dx = viewportWidth / Gdx.graphics.getWidth();
		dy = viewportHeight / Gdx.graphics.getHeight();
	}

	public float getWidth(){
		return viewportWidth * zoom;
	}
	
	public float getHeight(){
		return viewportHeight * zoom;
	}
	
	public float getLeft(){
		return position.x - viewportWidth * zoom * 0.5f;
	}
	
	public float getRight(){
		return position.x + viewportWidth * zoom * 0.5f;
	}
	
	public float getBottom(){
		return position.y - viewportHeight * zoom * 0.5f;
	}
	
	public float getTop(){
		return position.y + viewportHeight * zoom * 0.5f;
	}
	
	public void toCameraCoord(Vector2 coord){
		coord.x = coord.x * dx * zoom + getLeft();
		coord.y = coord.y * dy * zoom + getBottom();
	}
	
	public void toScreenCoord(Vector2 coord){
		coord.x = (coord.x - getLeft()) / (dx * zoom);
		coord.y = (coord.y - getBottom()) / (dy * zoom);
	}
}
