package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public class Button extends Sprite {
	public boolean touched;
	public int pointer;
	public static final String TAG = "Agenthon_Button";
	
	public Button(Texture texture) {
		super(texture);
		touched = false;
	}
	
	public void touchDown(Vector3 touchPos, int pointer) {
		if (!touched) {
			if (getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
				touched = true;
				this.pointer = pointer;
				Gdx.app.log(TAG, "touched");
			}
		}
	}
	
	public void touchUp(int pointer) {
		if (touched) {
			if (this.pointer == pointer) {
				touched = false;
				Gdx.app.log(TAG, "released");
			}
		}
	}
	
	public void touchDragged(Vector3 touchPos, int pointer) {
		
	}
}
