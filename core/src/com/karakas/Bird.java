package com.karakas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 110;
    private Rectangle birdEdge;
    private Vector2 position;
    private Vector2 velocity;

    private Texture bird;

    public Bird(int x , int y)
    {
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        bird = new Texture(Gdx.files.internal("bird1gif.gif"));
        birdEdge = new Rectangle(x,y,bird.getWidth(),bird.getHeight());
    }

    public void update(float dt)
    {
        if(position.y > 0)
        {
            velocity.add(0,GRAVITY);
        }
        velocity.add(0,GRAVITY);
        velocity.scl(dt);
        position.add(MOVEMENT * dt,velocity.y);
        if(position.y < 0)
        {
            position.y = 0;
        }

        velocity.scl(1/dt);

        birdEdge.setPosition(position.x,position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture()
    {
        return bird;
    }

    public void jump()
    {
        velocity.y = 400;
    }

    public Rectangle getBirdEdge()
    {
        return birdEdge;
    }

    public void dispose()
    {
        bird.dispose();
    }

}
