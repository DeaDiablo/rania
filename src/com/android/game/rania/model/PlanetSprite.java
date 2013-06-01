package com.android.game.rania.model;

import com.android.game.rania.model.element.RegionID;
import com.android.game.rania.model.element.StaticObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlanetSprite extends StaticObject{

	public Planet planet = null;
	private float time = 0.0f;

	public PlanetSprite(Planet planet) {
		super(RegionID.PLANET, 150, 150);
		this.planet = planet;
	}
	
	@Override
	public void draw(SpriteBatch sprite){
		if (!visible)
			return;
		
		time += Gdx.graphics.getDeltaTime();
		position.set((float)Math.cos(Math.toRadians(planet.speed * time)), (float)Math.sin(Math.toRadians(planet.speed * time)));
		position.mul(planet.orbit);
		angle = planet.speed * time + 45.0f;
		
		super.drawRegion(sprite, region);
	}
}
