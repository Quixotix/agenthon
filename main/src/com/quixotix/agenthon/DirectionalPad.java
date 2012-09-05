package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class DirectionalPad extends Button {
	float xVelocity, yVelocity;
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
        xVelocity = 0;
        yVelocity = 0;
	}
	
	@Override
	public void touchDragged(Vector3 touchPos, int pointer) {
		if (touched) {
			if (this.pointer == pointer) {
				xVelocity = (touchPos.x - centerX) / halfWidth;
                if (xVelocity > 1) xVelocity = 1;
                if (xVelocity < -1) xVelocity = -1;
				yVelocity = (touchPos.y - centerY) / halfHeight;
                if (yVelocity > 1) yVelocity = 1;
                if (yVelocity < -1) yVelocity = -1;
			}
		}
	}
	
	@Override
	public void touchUp(int pointer) {
		if (touched) {
			if (this.pointer == pointer) {
				touched = false;
				xVelocity = 0;
				yVelocity = 0;
				Gdx.app.debug(TAG, "DirectionalPad.touchUp()");
			}
		}
	}
}
