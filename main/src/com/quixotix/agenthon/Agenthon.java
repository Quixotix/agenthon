package com.quixotix.agenthon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Agenthon implements ApplicationListener {
    public static final String TAG = "Agenthon";
    private OrthographicCamera camera;
    private ControlProcessor controlProcessor;
    private SpriteBatch batch;
    private Player player;
    
    @Override
    public void create() {        
        // Gdx.app.setLogLevel(Application.LOG_ERROR);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.debug(TAG, "Agenthon.create()");
        
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
        camera = new OrthographicCamera(w, h);
        camera.setToOrtho(false);
        
        controlProcessor = new ControlProcessor();
        Gdx.input.setInputProcessor(controlProcessor);
        
        batch = new SpriteBatch();
        
        player = new Player(0, 128);
    }

    @Override
    public void dispose() {
        Gdx.app.debug(TAG, "Agenthon.dispose()");
        batch.dispose();
    }

    @Override
    public void render() {        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
        
        controlProcessor.draw(batch);
        
        player.xVelocity = controlProcessor.dPad.xVelocity * 3;
        player.yVelocity = controlProcessor.dPad.yVelocity * 3;
        player.update();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.debug(TAG, "Agenthon.resize()");
    }

    @Override
    public void pause() {
        Gdx.app.debug(TAG, "Agenthon.pause()");
    }

    @Override
    public void resume() {
        Gdx.app.debug(TAG, "Agenthon.resume()");
    }
}
