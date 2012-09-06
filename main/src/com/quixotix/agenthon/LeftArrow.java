package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class LeftArrow extends Button {
	public LeftArrow() {
		super(new Texture(Gdx.files.internal("textures/arrowleft.png")));
        setX(0);
        setY(64);
	}
}
