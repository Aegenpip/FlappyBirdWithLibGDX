package com.karakas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class MenuScreen extends Screen {

    private  Texture background;
    private  Texture startBtn;
    private Texture flappyBird;
    public MenuScreen(ScreenManager sm) {
        super(sm);
        background = new Texture(Gdx.files.internal("background.png"));
        flappyBird = new Texture(Gdx.files.internal("FlappyBird.png"));
        startBtn = new Texture(Gdx.files.internal("start_button.png"));
    }

    @Override
    public void handleInput() {
    if(Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            sm.set(new GameScreen(sm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background,0,0, Main.WIDTH,Main.HEIGHT);
        batch.draw(flappyBird,200,400,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        batch.draw(startBtn,(Main.WIDTH/2) - startBtn.getWidth()/2,(Main.HEIGHT/2)-100);
        batch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        startBtn.dispose();
        flappyBird.dispose();
    }
}
