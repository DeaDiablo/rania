package com.android.game.rania.model;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.model.element.ObjectID;
import com.android.game.rania.model.element.StaticObject;
import com.android.game.rania.view.Camera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
 
public class ParallaxLayer extends StaticObject{
    
	private float ratio = 0.0f;
	private Sprite drawable = null;
	private Camera camera = null;
	
    public ParallaxLayer(ObjectID id, float delta, float alpha) {
        super(id, 0, 0);
        ratio = delta;
        drawable = new Sprite();
        drawable.setColor(1.0f, 1.0f, 1.0f, alpha);
        camera = RaniaGame.mView.getCamera();
    }
    
    @Override
    public void draw(SpriteBatch sprite, TextureRegion region){
		if (!visible)
			return;

		final float width  = camera.getWidth();
		final float height = camera.getHeight();
		final float layerOffsetX = camera.position.x * ratio % width;
		final float layerOffsetY = camera.position.y * ratio % height;
		final float positionX = camera.getLeft();
		final float positionY = camera.getBottom();

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