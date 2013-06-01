package com.android.game.rania.model.ui;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class HelperUI {
	
	private Handler uiThread = null;
	private Context appContext = null;
	
	public HelperUI(Context appContext) {
	    uiThread = new Handler();
	    this.appContext = appContext;
	}
	
	public void showToastShort(final String message) {
	    uiThread.post(new Runnable() {
	        @Override
	        public void run() {
	            Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show();
	        }
	    });
	}
	
	public void showToastLong(final String message) {
	    uiThread.post(new Runnable() {
	        @Override
	        public void run() {
	            Toast.makeText(appContext, message, Toast.LENGTH_LONG).show();
	        }
	    });
	}
}
