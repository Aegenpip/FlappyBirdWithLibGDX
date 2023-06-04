package com.karakas;

import  com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Pipe {
    public static final int PIPE_WIDTH = 52;
    private static final int  PIPE_GAP = 90;
    private static final int LOWEST_POSITION = 100;
    private Rectangle topPipeEdge , botPipeEdge;
    private Texture topPipe , botPipe;
    private Vector2 posTopPipe , posBotPipe;
    private Random random;

    public Pipe(float x)
    {
        topPipe =new Texture(Gdx.files.internal("topPipe.png"));
        botPipe =new Texture(Gdx.files.internal("botPipe.png"));
        random = new Random();

        posTopPipe = new Vector2(x,random.nextInt(150) + PIPE_GAP + LOWEST_POSITION );
        posBotPipe = new Vector2(x,posTopPipe.y - PIPE_GAP - botPipe.getHeight());

        botPipeEdge = new Rectangle(posBotPipe.x, posBotPipe.y, botPipe.getWidth(), botPipe.getHeight());
        topPipeEdge = new Rectangle(posTopPipe.x, posTopPipe.y, topPipe.getWidth(), topPipe.getHeight());
    }

    public Texture getTopPipe() {
        return topPipe;
    }

    public Texture getBotPipe() {
        return botPipe;
    }

    public Vector2 getPosTopPipe() {
        return posTopPipe;
    }

    public Vector2 getPosBotPipe() {
        return posBotPipe;
    }

    public void reposition(float x)
    {
        posTopPipe.set(x,random.nextInt(150) + PIPE_GAP + LOWEST_POSITION);
        posBotPipe.add(x,posTopPipe.y - PIPE_GAP - botPipe.getHeight());

        topPipeEdge.setPosition(posTopPipe.x,posTopPipe.y);
        botPipeEdge.setPosition(posBotPipe.x,posBotPipe.y);
    }

    public boolean collides(Rectangle bird)
    {
        return bird.overlaps(topPipeEdge) || bird.overlaps(botPipeEdge);
    }

    public void dispose()
    {
        topPipe.dispose();
        botPipe.dispose();
    }
}
