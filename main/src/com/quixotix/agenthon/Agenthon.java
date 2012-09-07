package com.quixotix.agenthon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Agenthon extends Game {

    public static final String TAG = "Agenthon";
    
    private static boolean showSplash = true;
    
    // screens
    public GameScreen gameScreen;
    public MenuScreen menuScreen;
    
    /*
    private OrthographicCamera camera;
    private ControlProcessor controlProcessor;
    private SpriteBatch batch;
    private Player player;
    */
    
    @Override
    public void create() {               
        // Gdx.app.setLogLevel(Application.LOG_ERROR);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.debug(TAG, "Agenthon.create()");
        
        // create screens
        gameScreen = new GameScreen(this);
        menuScreen = new MenuScreen(this);
        
        if (showSplash) {
            setScreen(new SplashScreen(this)); 
        } else {
            setScreen(gameScreen);
        }
        
        /*
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
        camera = new OrthographicCamera(w, h);
        camera.setToOrtho(false);
        
        controlProcessor = new ControlProcessor();
        Gdx.input.setInputProcessor(controlProcessor);
        
        batch = new SpriteBatch();
        player = new Player(0, 128);
        */
    }

    @Override
    public void dispose() {
        super.dispose();
        Gdx.app.debug(TAG, "Agenthon.dispose()");
        gameScreen.dispose();
        menuScreen.dispose();
    }
}
