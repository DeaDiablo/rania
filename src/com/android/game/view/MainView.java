package com.android.game.view;

import java.util.EnumMap;
import java.util.Vector;

import com.android.game.rania.model.Model;
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
	private EnumMap<Model.ModelID, TextureRegion> textureRegions = new EnumMap<Model.ModelID, TextureRegion>(Model.ModelID.class);
	private SpriteBatch spriteBatch = null;
	private TextureRegion region = null;
	
	public MainView(){
		//create camera
		camera = new OrthographicCamera(heightSize * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), heightSize);
		camera.position.set(0.0f, 0.0f, 0.0f);
		camera.update();
		
		spriteBatch = new SpriteBatch();
	}
	
	public void setTextureRegion(Texture texture, Model.ModelID idModel){
		textureRegions.put(idModel, new TextureRegion(texture));
	}
	
	public void draw(Vector<Model> objects){
		//update camera
		camera.update();
		
		//render objects
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		for (Model object : objects) {
			region = textureRegions.get(object.getObjectID());
			spriteBatch.draw(region, -region.getRegionWidth() * 0.5f, -region.getRegionHeight() * 0.5f);
		}
		spriteBatch.end();
	}
}
