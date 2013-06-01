package com.android.game.rania.model;

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
		//Vector<Planet> planets = RaniaGame.nController.GetCurrentPlanets(RaniaGame.mUser);
		//for (Planet planet : planets) {
			//AddElement(new PlanetSprite(planet));
		//}
		
		Planet pl = new Planet();
		pl.id = 0;
		pl.orbit = 450;
		pl.planetName = "Earth";
		pl.planetType = 0;
		pl.radius = 100;
		pl.speed = 10;
		AddElement(new PlanetSprite(pl));
	}
}
