package com.quixotix.agenthon;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashScreen implements InputProcessor, Screen {

    public Agenthon game;
    
    private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
    
    public SplashScreen(Agenthon game) {
        this.game = game;
    }
    
    @Override
    public void render(float delta) {        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.debug(Agenthon.TAG, String.format("SplashScreen.resize(%d, %d)", width, height));
    }

    @Override
    public void show() {
        Gdx.app.debug(Agenthon.TAG, "SplashScreen.show()");
        Gdx.input.setInputProcessor(this);
        
        float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false);
        
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("textures/splash-logo.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		
		// center
		sprite.setPosition((width/2)-(sprite.getWidth()/2), (height/2)-(sprite.getHeight()/2));
    }


    @Override
    public void hide() {
        Gdx.app.debug(Agenthon.TAG, "SplashScreen.hide()");
        Gdx.input.setInputProcessor(null);
        batch.dispose();
		texture.dispose();
    }

    @Override
	public boolean keyDown(int keycode) {
	    Gdx.app.debug(Agenthon.TAG, "SplashScreen.keyDown()");
	    game.setScreen(game.gameScreen);
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
	    game.setScreen(game.gameScreen);
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
        Gdx.app.debug(Agenthon.TAG, "SplashScreen.dispose()");
    }
}
