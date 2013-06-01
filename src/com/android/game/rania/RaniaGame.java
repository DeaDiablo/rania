package com.android.game.rania;

import android.content.Context;

import com.android.game.rania.controller.MainController;
import com.android.game.rania.model.ui.HelperUI;
import com.android.game.rania.net.NetController;
import com.android.game.rania.screen.MainMenu;
import com.android.game.rania.userdata.User;
import com.android.game.rania.view.MainView;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class RaniaGame extends Game {
	
	//game
	public static RaniaGame      mGame       = null;
	
	//mvc
	public static MainView       mView       = null;
	public static MainController mController = null;
	
	//helpers
	public static Context        mContext    = null;
	public static HelperUI       mHelperUI   = null;
	
	//network
	public static NetController  nController = null;
	public static User           mUser       = null;
	
	public RaniaGame(Context context) {
		super();
		mContext = context;
		mHelperUI = new HelperUI(mContext);
	}

	@Override
	public void create() {
		mGame = this;
		mView = new MainView();
		mController = new MainController();
		mUser = new User();
		nController = new NetController();
		setScreen(new MainMenu());
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
