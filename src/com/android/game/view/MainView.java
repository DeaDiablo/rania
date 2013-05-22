package com.android.game.view;

import java.util.EnumMap;
import java.util.Vector;

import com.android.game.rania.model.DynamicObject;
import com.android.game.rania.model.ObjectID;
import com.android.game.rania.model.StaticObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainView {
	
	//camera
	private OrthographicCamera camera = null;
	private final float heightSize = 384.0f;
	
	//sprites and regions
	private EnumMap<ObjectID, TextureRegion> textureRegions = new EnumMap<ObjectID, TextureRegion>(ObjectID.class);
	private SpriteBatch spriteBatch = null;
	private TextureRegion region = null;
	
	public MainView(){
		//create camera
		camera = new OrthographicCamera(heightSize * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), heightSize);
		camera.position.set(0.0f, 0.0f, 0.0f);
		camera.update();
		
		spriteBatch = new SpriteBatch();
	}
	
	public void setTextureRegion(Texture texture, ObjectID idModel){
		textureRegions.put(idModel, new TextureRegion(texture));
	}
	
	public void update(){
	}
	
	public void draw(Vector<DynamicObject> dynamicObjects, Vector<StaticObject> staticObjects){
		//update camera
		camera.update();
		
		//start render
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();

		//render static objects
		for (StaticObject object : staticObjects) {
			region = textureRegions.get(object.getObjectID());
			spriteBatch.draw(region, object.getPositionX() - region.getRegionWidth() * 0.5f, object.getPositionY() - region.getRegionHeight() * 0.5f);
		}

		//render dynamic objects
		for (DynamicObject object : dynamicObjects) {
			region = textureRegions.get(object.getObjectID());
			spriteBatch.draw(region, object.getPositionX() - region.getRegionWidth() * 0.5f, object.getPositionY() - region.getRegionHeight() * 0.5f);
		}
		
		//end render
		spriteBatch.end();
	}
}
