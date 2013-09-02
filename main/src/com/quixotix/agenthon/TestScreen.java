package com.quixotix.agenthon;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class TestScreen implements InputProcessor, Screen {
    public Agenthon game;   // move to abstract base 
    
    private Stage stage;        
	private Texture texture;

    // move to abstract base 
    public TestScreen(Agenthon game) {
        this.game = game;
    }
    
    @Override
    public void render(float delta) {    
        Gdx.gl.glClearColor(0, 50, 50, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
		stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    
    }

    @Override
    public void show() {
        Gdx.app.debug(Agenthon.TAG, "TestScreen.show()");

        stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
        TestActor actor = new TestActor(); 
        stage.addActor(actor);
        
        // this class AND the actor are input processors
        InputMultiplexer inputMultiplexer = new InputMultiplexer(this, stage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void hide() {
        Gdx.app.debug(Agenthon.TAG, "TestScreen.hide()");
        stage.dispose();
    }
	
    @Override
    public void pause() {
        Gdx.app.debug(Agenthon.TAG, "TestScreen.pause()");
    } 

    @Override
    public void resume() {
        Gdx.app.debug(Agenthon.TAG, "TestScreen.resume()");
    }

    @Override
    public void dispose() {
        Gdx.app.debug(Agenthon.TAG, "TestScreen.dispose()");
    }
    
    
    @Override
	public boolean keyDown(int keycode) {
	    Gdx.app.debug(Agenthon.TAG, "TestScreen.keyDown()");
	    if(keycode == Keys.BACK || keycode == Keys.BACKSPACE) {
	        game.setScreen(game.menuScreen);
		    return true;
	    }
	    
	    return false;
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
	    return false;
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
}
