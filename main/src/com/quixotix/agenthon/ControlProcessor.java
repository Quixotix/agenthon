package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class ControlProcessor implements InputProcessor {
	private OrthographicCamera camera;
	public SwordButton swordButton;
	public DirectionalPad dPad;
	public static final String TAG = "Agenthon_ControlProcessor";
	public ControlProcessor() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(w, h);
        camera.setToOrtho(false);
        
		swordButton = new SwordButton();
		dPad = new DirectionalPad();
	}
	
	public void draw(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		swordButton.draw(batch);
		dPad.draw(batch);
		batch.end();
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector3 touchPos = new Vector3();
		touchPos.set(screenX, screenY, 0);
		camera.unproject(touchPos);
		swordButton.touchDown(touchPos, pointer);
		dPad.touchDown(touchPos, pointer);
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		swordButton.touchUp(pointer);
		dPad.touchUp(pointer);
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Vector3 touchPos = new Vector3();
		touchPos.set(screenX, screenY, 0);
		camera.unproject(touchPos);
		dPad.touchDragged(touchPos, pointer);
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
