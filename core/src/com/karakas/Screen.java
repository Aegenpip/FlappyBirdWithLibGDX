package com.karakas;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Screen {
    public OrthographicCamera cam;
    public ScreenManager sm;

    protected Screen(ScreenManager sm)
    {
        this.sm = sm;
        cam = new OrthographicCamera();
    }

    public abstract void  handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch batch);

    public abstract void dispose();

}

