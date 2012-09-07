package com.quixotix.agenthon;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SplashScreen implements InputProcessor, Screen {

    public Agenthon game;
    
    private Stage stage;
	private Texture texture;
	

    public SplashScreen(Agenthon game) {
        this.game = game;
    }
    
    @Override
    public void render(float delta) {    
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void show() {
        Gdx.app.debug(Agenthon.TAG, "SplashScreen.show()");

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		stage = new Stage(width, height, true);
		stage.getCamera().position.set(width/2, height/2, 0);
		texture = new Texture(Gdx.files.internal("textures/splash.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 301);
		Image image = new Image(region);
		image.setFillParent(true);
		stage.addActor(image);
		
		Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        // cleanup in hide() rather than dispose since a splash screen is only
        // show once.
        Gdx.app.debug(Agenthon.TAG, "SplashScreen.hide()");
        Gdx.input.setInputProcessor(null);
		texture.dispose();
		stage.dispose();
    }

    @Override
	public boolean keyDown(int keycode) {
	    Gdx.app.debug(Agenthon.TAG, "SplashScreen.keyDown()");
	    game.setScreen(game.menuScreen);
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}
	
	@Override
	public boolean keyTyped(char character) {
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Gdx.app.debug(Agenthon.TAG, "SplashScreen.touchDown()");
	    game.setScreen(game.menuScreen);
	    return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
    @Override
    public void pause() {
    
    } 

    @Override
    public void resume() {
    
    }

    @Override
    public void dispose() {

    }
}
