package com.android.game.rania.model;

import com.android.game.rania.model.element.ObjectID;
import com.android.game.rania.model.element.StaticObject;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 
public class ParallaxLayer extends StaticObject{
    
	private float ratio = 0.0f;
	private Sprite drawable = null;
	
    public ParallaxLayer(ObjectID id, float delta, float alpha) {
        super(id, 0, 0);
        ratio = delta;
        drawable = new Sprite();
        drawable.setColor(1.0f, 1.0f, 1.0f, alpha);
    }
    
    @Override
    public void draw(OrthographicCamera camera, SpriteBatch sprite, TextureRegion region){
		if (!visible)
			return;

		final float width  = camera.viewportWidth * camera.zoom;
		final float height = camera.viewportHeight * camera.zoom;
		final float layerOffsetX = camera.position.x * ratio % width;
		final float layerOffsetY = camera.position.y * ratio % width;
		final float positionX = camera.position.x - width  * 0.5f;
		final float positionY = camera.position.y - height * 0.5f;

		drawable.setRegion(region);
		drawable.setSize(width, height);
		drawable.setPosition(positionX, positionY);
		drawable.setRegion((positionX + layerOffsetX) / region.getRegionWidth(),
						   (positionY + height + layerOffsetY) / region.getRegionHeight(),
						   (positionX + width + layerOffsetX) / region.getRegionWidth(),
						   (positionY + layerOffsetY) / region.getRegionHeight());
		drawable.draw(sprite);
    }
}