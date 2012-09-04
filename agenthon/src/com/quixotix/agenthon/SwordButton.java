package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SwordButton extends Sprite {
	public SwordButton(float screenWidth) {
		super(new Texture(Gdx.files.internal("swordbutton.png")));
		setX(screenWidth - getWidth());
		setY(0);
	}
}
