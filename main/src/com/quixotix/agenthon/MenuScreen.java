package com.quixotix.agenthon;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class MenuScreen implements Screen {

    public Agenthon game;
    
    private Stage stage;
	private Texture texture;
	

    public MenuScreen(Agenthon game) {
        this.game = game;
    }
    
    @Override
    public void render(float delta) {    
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    
    }

    private void setupStage() {
        Gdx.app.debug(Agenthon.TAG, "MenuScreen.setupStage()");
        float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		stage = new Stage(width, height, true);
		
		//Skin skin = new Skin(Gdx.files.internal("skins/ui.json"), 
		//                     Gdx.files.internal("buttons/ui.png"));
		
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("textures/images-packed.atlas"));
		Skin skin = new Skin(Gdx.files.internal("skins/buttons.json"), atlas);
		//skin.addRegions(atlas);
		//TextButtonStyle style = skin.get("default", TextButtonStyle.class);
		//BitmapFont font = new BitmapFont();
		
		
		
		//style.fontColor = Color.WHITE;
		//style.downFontColor = Color.RED;
		//style.font = font;
		
		// buttons
		TextButton playButton = new TextButton("Play Game", skin, "green");
		playButton.setPosition(450, 350);
		playButton.addListener(new InputListener() {
		    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    return true;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(game.gameScreen);
            }
		});
		stage.addActor(playButton);
		
		TextButton optionsButton = new TextButton("Options", skin, "green");
		optionsButton.setPosition(450, 200);
		stage.addActor(optionsButton);
		
		TextButton helpButton = new TextButton("Help", skin, "green");
		helpButton.setPosition(450, 50);
		stage.addActor(helpButton);
		
    }
    
    @Override
    public void show() {
        Gdx.app.debug(Agenthon.TAG, "MenuScreen.show()");
        
        // create stage on first show only
        if (stage == null) {
            setupStage();
        }
        
        // grab input
        Gdx.input.setInputProcessor(stage);
		
		// stage.getCamera().position.set(width/2, height/2, 0);
		// texture = new Te<xture(Gdx.files.internal("textures/ui.png"));
		// texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		// TextureRegion region = new TextureRegion(texture, 0, 0, 512, 301);
		// Image image = new Image(region);
		// image.setFillParent(true);
		// stage.addActor(image);
		
		
    }

    @Override
    public void hide() {
        // cleanup in hide() rather than dispose since a splash screen is only
        // show once.
        Gdx.app.debug(Agenthon.TAG, "MenuScreen.hide()");
        Gdx.input.setInputProcessor(null);
		// texture.dispose();
		//stage.dispose();
    }
	
    @Override
    public void pause() {
    
    } 

    @Override
    public void resume() {
    
    }

    @Override
    public void dispose() {
		if (stage != null) stage.dispose();
    }
}
