package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class ControlProcessor implements InputProcessor {
	private OrthographicCamera camera;
	public SwordButton swordButton;
	public UpArrow upArrow;
    public DownArrow downArrow;
    public LeftArrow leftArrow;
    public RightArrow rightArrow;
	public static final String TAG = "Agenthon";
	
	public ControlProcessor() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(w, h);
        camera.setToOrtho(false);
        
		swordButton = new SwordButton();
        upArrow = new UpArrow();
        downArrow = new DownArrow();
        leftArrow = new LeftArrow();
        rightArrow = new RightArrow();
	}
	
	public void draw(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		swordButton.draw(batch);
		upArrow.draw(batch);
        downArrow.draw(batch);
        leftArrow.draw(batch);
        rightArrow.draw(batch);
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
		upArrow.touchDown(touchPos, pointer);
		downArrow.touchDown(touchPos, pointer);
		leftArrow.touchDown(touchPos, pointer);
		rightArrow.touchDown(touchPos, pointer);
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		swordButton.touchUp(pointer);
		upArrow.touchUp(pointer);
		downArrow.touchUp(pointer);
		leftArrow.touchUp(pointer);
		rightArrow.touchUp(pointer);
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Vector3 touchPos = new Vector3();
		touchPos.set(screenX, screenY, 0);
		camera.unproject(touchPos);
		upArrow.touchDragged(touchPos, pointer);
		downArrow.touchDragged(touchPos, pointer);
		leftArrow.touchDragged(touchPos, pointer);
		rightArrow.touchDragged(touchPos, pointer);
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
