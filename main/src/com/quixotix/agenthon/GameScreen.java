package com.quixotix.agenthon;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

    public Agenthon game;
    
    private OrthographicCamera camera;
    private ControlProcessor controlProcessor;
    private SpriteBatch batch;
    private Player player;
    
    public GameScreen(Agenthon game) {
        this.game = game;
    }
    
    @Override
    public void render(float delta) {        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        player.draw(batch);
        batch.end();
        
        controlProcessor.draw(batch);
        
        if (controlProcessor.upArrow.touched) {
            player.north = true;
        } else {
            player.north = false;
        }
        if (controlProcessor.downArrow.touched) {
            player.south = true;
        } else {
            player.south = false;
        }
        if (controlProcessor.leftArrow.touched) {
            player.west = true;
        } else {
            player.west = false;
        }
        if (controlProcessor.rightArrow.touched) {
            player.east = true;
        } else {
            player.east = false;
        }
        player.update();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.debug(Agenthon.TAG, String.format("GameScreen.resize(%d, %d)", width, height));
    }

    @Override
    public void show() {
        Gdx.app.debug(Agenthon.TAG, "GameScreen.show()");
        
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
    public void hide() {
        Gdx.app.debug(Agenthon.TAG, "GameScreen.hide()");
    }


    @Override
    public void pause() {
        Gdx.app.debug(Agenthon.TAG, "GameScreen.pause()");
    } 

    @Override
    public void resume() {
        Gdx.app.debug(Agenthon.TAG, "GameScreen.resume()");
    }

    @Override
    public void dispose() {
        Gdx.app.debug(Agenthon.TAG, "GameScreen.dispose()");
        if (batch != null) batch.dispose();
    }
}
