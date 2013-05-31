package com.android.game.rania;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.model.element.Locations;
import com.android.game.rania.model.element.Planets;
import com.android.game.rania.net.NetController;
import com.android.game.rania.screen.MainMenu;
import com.android.game.rania.userdata.User;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class RaniaGame extends Game {
	
	public static RaniaGame      mGame       = null;
	public static Context		 mContext    = null;
	public static MainView       mView       = null;
	public static MainController mController = null;
	public static NetController  nController = null;
	public static User           mUser       = null;
	public static List<Locations>mLocations;
	public static List<Planets>  mPlanets;
	
	public RaniaGame(Context context) {
		super();
		mContext = context;
	}

	@Override
	public void create() {
		mGame = this;
		mView = new MainView();
		mController = new MainController();
		mUser = new User();
		nController = new NetController();
		mLocations = new ArrayList<Locations>();
		mPlanets = new ArrayList<Planets>();
		setScreen(new MainMenu());
		//setScreen(new SpaceScreen());
	}

	/*
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void render() {

	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	*/

	@Override
	public void dispose() {
		Gdx.app.exit();
	}
}
