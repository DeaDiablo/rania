package com.android.game.rania.model.element;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Object {
	
	public boolean  visible  = true;
	public Vector2  position = new Vector2(0.0f, 0.0f);
	public float	angle    = 0.0f;
	public Vector2	scale    = new Vector2(1.0f, 1.0f);
	public ObjectID idObject = ObjectID.NONE;
	
	public Object(ObjectID id, float posX, float posY, float rotAngle, float scaleX, float scaleY){
		idObject = id;
		position.set(posX, posY);
		angle = rotAngle;
		scale.set(scaleX, scaleY);
	}
	
	public DynamicObject asDynamicObject(){
		return null;
	}
	
	public StaticObject asStaticObject(){
		return null;
	}
	
	public HUDObject asHUDObject(){
		return null;
	}
	
	public void draw(OrthographicCamera camera, SpriteBatch sprite, TextureRegion region){
		if (!visible)
			return;
		sprite.draw(region, 
					position.x - region.getRegionWidth() * 0.5f,
					position.y - region.getRegionHeight() * 0.5f,
					region.getRegionWidth() * 0.5f,
					region.getRegionHeight() * 0.5f,
					region.getRegionWidth(),
					region.getRegionHeight(),
					scale.x,
					scale.y,
					angle);
	}
}
