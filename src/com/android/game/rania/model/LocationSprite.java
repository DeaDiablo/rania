package com.android.game.rania.model;

import java.util.HashMap;

import com.android.game.rania.RaniaGame;
import com.android.game.rania.model.element.Group;
import com.android.game.rania.model.element.RegionID;
import com.android.game.rania.model.element.StaticObject;

public class LocationSprite extends Group{

	public Location location;
		
	public LocationSprite(Location location){
		super();
		this.location = location;
		
		StaticObject star = new StaticObject(RegionID.STAR, 0, 0);
		star.scale.set(5, 5);
		AddElement(star);

		RaniaGame.mUser.isWorkReciver = false;
		HashMap<String, Planet> planets = RaniaGame.nController.GetCurrentPlanets(RaniaGame.mUser);
		for (Planet planet : planets.values()) {
			AddElement(new PlanetSprite(planet));
		}
		RaniaGame.mUser.isWorkReciver = true;
	}
}
