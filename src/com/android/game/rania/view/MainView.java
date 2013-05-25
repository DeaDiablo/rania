package com.android.game.rania.view;

import java.util.EnumMap;
import java.util.HashMap;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.model.element.DynamicObject;
import com.android.game.rania.model.element.Object;
import com.android.game.rania.model.element.ObjectID;
import com.android.game.rania.model.element.StaticObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainView {
	
	//camera
	private OrthographicCamera camera = null;
	private final float heightSize = 384.0f;
	
	//sprites
	private SpriteBatch spriteBatch = null;
	private SpriteBatch spriteBatchHUD = null;
	
	//textures
	private TextureRegion region = null;
	private HashMap<String, Texture> textures = new HashMap<String, Texture>();
	private EnumMap<ObjectID, TextureRegion> textureRegions = new EnumMap<ObjectID, TextureRegion>(ObjectID.class);
	
	public MainView(){
		//create camera
		camera = new OrthographicCamera(heightSize * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), heightSize);
		camera.position.set(0.0f, 0.0f, 0.0f);
		camera.update();
		
		spriteBatch = new SpriteBatch();
		spriteBatchHUD = new SpriteBatch();
	}
	
	public void loadTexture(String fileTexture, ObjectID id) {
		Texture texture = textures.get(fileTexture);
		if (texture == null)
		{
			texture = new Texture(Gdx.files.internal(fileTexture));
			textures.put(fileTexture, texture);
		}
		textureRegions.put(id, new TextureRegion(texture));
	}
	
	public void loadTexture(String fileTexture, ObjectID id, float x, float y, float width, float height) {
		Texture texture = textures.get(fileTexture);
		if (texture == null)
		{
			texture = new Texture(Gdx.files.internal(fileTexture));
			textures.put(fileTexture, texture);
		}
		textureRegions.put(id, new TextureRegion(texture, x, y, width, height));
	}
	
	public void unloadTexture(String fileTexture){
		textures.remove(fileTexture);
	}
	
	public Texture getTexture(String fileTexture){
		return textures.get(fileTexture);
	}
	
	public Texture getTexture(ObjectID id){
		TextureRegion regTexture = textureRegions.get(id);
		if (regTexture == null)
			return null;
		return regTexture.getTexture();
	}
	
	public void clear(){
		textureRegions.clear();
		for(Texture texture : textures.values()){
			texture.dispose();
		}
		textures.clear();
	}
	
	public void draw(){
		DynamicObject player = RaniaGame.mController.getPlayer();
		
		//update camera
		camera.update();
		camera.position.set(player.position.x, player.position.y, 0);
		
		//start render
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();

		//render static objects
		for (StaticObject object : RaniaGame.mController.getStaticObjects()) {
			drawObject(spriteBatch, object);
		}

		//render dynamic objects
		for (DynamicObject object : RaniaGame.mController.getDynamicObjects()) {
			drawObject(spriteBatch, object);
		}
		
		//render player
		drawObject(spriteBatch, player);
		
		//end render
		spriteBatch.end();
		
		spriteBatchHUD.begin();
		//render HUD objects
		for (Object object : RaniaGame.mController.getHUDObjects()) {
			drawObject(spriteBatchHUD, object);
		}
		spriteBatchHUD.end();
	}
	
	private void drawObject(SpriteBatch sprite, Object object)	{
		if (!object.visible)
			return;
		region = textureRegions.get(object.idObject);
		sprite.draw(region, 
					object.position.x - region.getRegionWidth() * 0.5f,
					object.position.y - region.getRegionHeight() * 0.5f,
					region.getRegionWidth() * 0.5f,
					region.getRegionHeight() * 0.5f,
					region.getRegionWidth(),
					region.getRegionHeight(),
					object.scale.x,
					object.scale.y,
					object.angle);
	}
}
