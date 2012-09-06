package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class DownArrow extends Button {
	public DownArrow() {
		super(new Texture(Gdx.files.internal("textures/arrowdown.png")));
        setX(64);
        setY(0);
	}
}
