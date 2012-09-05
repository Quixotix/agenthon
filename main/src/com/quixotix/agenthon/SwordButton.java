package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SwordButton extends Button {
	
	public SwordButton() {
		super(new Texture(Gdx.files.internal("swordbutton.png")));
		float screenWidth = Gdx.graphics.getWidth();
		setX(screenWidth - getWidth());
		setY(0);
	}
}
