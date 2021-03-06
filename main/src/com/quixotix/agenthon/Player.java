package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
	public int x, y;
	public int width, height;
	private Texture sheet;
	public TextureRegion[][] frames;
	private int frameX, frameY;
	private boolean attacking;
	public boolean north, east, south, west;
    public float speed;
	public static final String TAG = "Agenthon";
	public final int textureColumns = 16;
	public final int textureRows = 4;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		frameX = 0;
		frameY = 2;
		width = 64;
		height = 64;
		sheet = new Texture(Gdx.files.internal("textures/player.png"));
        frames = TextureRegion.split(sheet, sheet.getWidth() / textureColumns,
        		sheet.getHeight() / textureRows);
        attacking = false;
        north = east = south = west = false;
        speed = 3;
	}
	
	public void update() {
        if (north) {
            y += speed;
        } else if (east) {
            x += speed;
        } else if (south) {
            y -= speed;
        } else if (west) {
            x -= speed;
        }
	}
	
	public void draw(SpriteBatch batch) {
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.draw(frames[frameY][frameX], x, y);
	}
	
	public void dispose() {
		sheet.dispose();
	}
	
	public void handleCollision(Player p) {
	    int overlapX = Math.min(x + width, p.x + p.width) - Math.max(x, p.x);
	    int overlapY = Math.min(y + height, p.y + p.height) - Math.max(y, p.y);
	    if (Math.abs(overlapY) < Math.abs(overlapX)) {
		    if (y < p.y) {
		        y -= overlapY;
		    }
		    else { 
		        y += overlapY;
		    }
	    } else {
	        if (x < p.x) {
		      x -= overlapX;
	        } else {
		      x += overlapX;
	        }
	    }
	}

	public boolean collidesWith(Player p) { 
	    return x < (p.x + p.width) && (x + width) > p.x && y < (p.y + p.height) && (y + height) > p.y;
	}
}
