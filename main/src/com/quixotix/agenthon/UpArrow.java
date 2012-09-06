package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class UpArrow extends Button {
	public UpArrow() {
		super(new Texture(Gdx.files.internal("arrowup.png")));
        setX(64);
        setY(128);
	}
}
