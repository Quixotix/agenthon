package com.quixotix.agenthon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener; //?
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;

class TestActor extends Actor {
    private Sprite sprite;
    private TextureAtlas atlas; // move to game or singleton and dispose when done
    
    public TestActor() {   
        // get sprite from image atlas (source is agenthon/images)
        atlas = new TextureAtlas(Gdx.files.internal("textures/images-packed.atlas"));
        sprite = atlas.createSprite("logo-96");
        
        // http://stackoverflow.com/questions/12487052/cannot-get-events-working-in-my-libgdx-actor/12496745#12496745
        setWidth(sprite.getWidth());
        setHeight(sprite.getHeight());
        setBounds(0, 0, getWidth(), getHeight());

        // setup input listeners
        addListener(new InputListener() {
            @Override
		    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	            Gdx.app.debug(Agenthon.TAG, "TestActor.touchDown()");
                return true;  // must return true for touchUp event to occur
            }
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.debug(Agenthon.TAG, "TestActor.touchUp()");
            }
		});

    }
    
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        // Color color = getColor();
        // batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(sprite, getX(), getY());
    }            
}
