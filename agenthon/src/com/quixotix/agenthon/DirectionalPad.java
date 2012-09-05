package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class DirectionalPad extends Button {
	float offsetX, offsetY;
	float centerX, centerY;
	float halfWidth, halfHeight;
	public DirectionalPad() {
		super(new Texture(Gdx.files.internal("dpad.png")));
		setX(0);
		setY(0);
		halfWidth = getWidth() / 2;
		halfHeight = getHeight() / 2;
		centerX = getX() + halfWidth;
		centerY = getY() + halfHeight;
	}
	
	@Override
	public void touchDragged(Vector3 touchPos, int pointer) {
		if (touched) {
			if (this.pointer == pointer) {
				offsetX = (touchPos.x - centerX) / halfWidth;
				offsetY = (touchPos.y - centerY) / halfHeight;
			}
		}
	}
	
	@Override
	public void touchUp(int pointer) {
		if (touched) {
			if (this.pointer == pointer) {
				touched = false;
				offsetX = 0;
				offsetY = 0;
				Gdx.app.log(TAG, "released");
			}
		}
	}
}
