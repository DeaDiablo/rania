package com.android.game.rania.screen;

import com.android.game.rania.RaniaGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;

public class MainMenu  implements Screen, InputProcessor{
		private Skin skin;
		private Stage stage;
		private Texture bgTexture;
		private TextureRegion bgRegion;
		private TextureRegion btLoginRegionUp;
		private TextureRegion btExitRegionUp;
		private TextureRegion btLoginRegionDown;
		private TextureRegion btExitRegionDown;
		private SpriteBatch spriteBatch;
		private OrthographicCamera cam;
		private float CAMERA_WIDTH = 800F;
		private float CAMERA_HEIGHT = 480F;
		private boolean downLogin;
		private boolean downExit;
		private int Width;
		private int Height;
		public float ppuX;
		public float ppuY;
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		skin.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		SetCamera(CAMERA_WIDTH/2f, CAMERA_HEIGHT / 2f);
		spriteBatch.setProjectionMatrix(this.cam.combined); 
		Gdx.gl.glClearColor(0,0,0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		showBG();
		spriteBatch.end();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		downLogin = false;
		downExit = false;
		spriteBatch = new SpriteBatch();
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		loadTextures();
		Gdx.input.setInputProcessor(this);
		Width = Gdx.graphics.getWidth();
		Height = Gdx.graphics.getHeight();
		ppuX = (float)Width / CAMERA_WIDTH;
		ppuY = (float)Height / CAMERA_HEIGHT;
		skin = new Skin(Gdx.files.internal("data/gui/uiskin.json"));
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
		TextField loginTextField = new TextField("", skin);
		loginTextField.setMessageText("Enter email");
		loginTextField.setTextFieldListener(new TextFieldListener() {
			public void keyTyped (TextField textField, char key) {
				if (key == '\n') textField.getOnscreenKeyboard().show(false);
			}
		});
		TextField passwordTextField = new TextField("", skin);
		passwordTextField.setMessageText("Enter Password");
		passwordTextField.setPasswordCharacter('*');
		passwordTextField.setPasswordMode(true);
		passwordTextField.setTextFieldListener(new TextFieldListener() {
			public void keyTyped (TextField textField, char key) {
				if (key == '\n') textField.getOnscreenKeyboard().show(false);
			}
		});
		Table container = new Table();
		
		container.setWidth(Width/CAMERA_WIDTH*280);
		container.setHeight(Height/CAMERA_HEIGHT*120);
		container.setX(Width/CAMERA_WIDTH+CAMERA_WIDTH/2f-70);
		container.setY(Height/CAMERA_HEIGHT+CAMERA_HEIGHT/2f-140);
	    container.row().fill(true).pad(5, 0, 5, 0);
	    container.add(loginTextField);
	    container.row().fill(true).pad(5, 0, 5, 0);
	    container.add(passwordTextField);
		stage.addActor(container);
		//Gdx.input.setInputProcessor(stage);
	}
	public void SetCamera(float x, float y){
	    this.cam.position.set(x, y,0);	
	    this.cam.update();
	}
	private void loadTextures(){
		
		bgTexture = new Texture(Gdx.files.internal("data/gui/index.png"));
		bgRegion = new TextureRegion(bgTexture, 0, 0, 800, 556);
		btLoginRegionUp = new TextureRegion(bgTexture, 0, 558, 140, 40);
		btExitRegionUp = new TextureRegion(bgTexture, 0, 598, 140, 40);
		btLoginRegionDown = new TextureRegion(bgTexture, 0, 638, 140, 40);
		btExitRegionDown = new TextureRegion(bgTexture, 0, 678, 140, 40);
	}
	public void showBG(){
		spriteBatch.draw(bgRegion,0,0, CAMERA_WIDTH, CAMERA_HEIGHT);
		if (downLogin) {spriteBatch.draw(btLoginRegionDown, CAMERA_WIDTH/2-50, 60+10, 100, 20);}
		else {spriteBatch.draw(btLoginRegionUp, CAMERA_WIDTH/2-50, 60+10, 100, 20);}
		if (downExit) {spriteBatch.draw(btExitRegionDown, CAMERA_WIDTH/2-50, 30+5, 100, 20);}
		else {spriteBatch.draw(btExitRegionUp, CAMERA_WIDTH/2-50, 30+5, 100, 20);}
	}
	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		if((y)/ppuY >= 390 && (y)/ppuY <= 410 && x/ppuX>=350 && x/ppuX<=450)
			downLogin = true;
		if((y)/ppuY >= 425 && (y)/ppuY <= 445 && x/ppuX>=350 && x/ppuX<=450)
			downExit = true;
		return true;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		if (downExit) {this.dispose();}
		if (downLogin) 
		{
			RaniaGame.mGame.setScreen(new SpaceScreen());
		}
		downLogin=false;
		downExit=false;
		return true;
	}

}
