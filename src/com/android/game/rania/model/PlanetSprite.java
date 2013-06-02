package com.android.game.rania.model;

import com.android.game.rania.model.element.RegionID;
import com.android.game.rania.model.element.StaticObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlanetSprite extends StaticObject{

	public Planet planet = null;
	private float time = 0.0f;

	public PlanetSprite(Planet planet) {
		super(RegionID.fromInt(RegionID.PLANET_0.ordinal() + planet.id), 0, 0);
		this.planet = planet;
		scale.set((float)planet.radius / region.getRegionWidth(), (float)planet.radius / region.getRegionHeight());
	}
	
	@Override
	public void draw(SpriteBatch sprite){
		if (!visible)
			return;
		
		time += Gdx.graphics.getDeltaTime();
		position.set((float)Math.cos(Math.toRadians(planet.speed * time)), (float)Math.sin(Math.toRadians(planet.speed * time)));
		position.mul(planet.orbit);
		angle = planet.speed * time + 45.0f;
		
		sprite.setColor(planet.color);
		super.drawRegion(sprite, region);
	}
}
