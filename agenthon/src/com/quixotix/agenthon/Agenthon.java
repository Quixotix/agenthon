package com.quixotix.agenthon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Agenthon implements ApplicationListener {
	private OrthographicCamera camera, hudCamera;
	private SpriteBatch batch;
	private SwordButton swordButton;
	private Player player;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(w, h);
        camera.setToOrtho(false);
        hudCamera = new OrthographicCamera(w, h);
        hudCamera.setToOrtho(false);
		batch = new SpriteBatch();
		
		swordButton = new SwordButton(w);
		player = new Player(128, 128);
	}

	@Override
	public void dispose() {
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
		batch.setProjectionMatrix(hudCamera.combined);
		batch.begin();
		swordButton.draw(batch);
		batch.end();
		
		player.update();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
