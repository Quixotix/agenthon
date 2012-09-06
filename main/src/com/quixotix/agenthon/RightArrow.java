package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RightArrow extends Button {
	public RightArrow() {
		super(new Texture(Gdx.files.internal("arrowright.png")));
        setX(128);
        setY(64);
	}
}
