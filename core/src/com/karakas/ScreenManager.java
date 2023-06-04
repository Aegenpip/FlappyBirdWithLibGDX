package com.karakas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class ScreenManager {

    private Stack<Screen> screens;

    public ScreenManager()
    {
        screens = new Stack<Screen>();
    }

    public void push(Screen screen)
    {
        screens.push(screen);
    }

    public void pop()
    {
        screens.pop();
    }

    public void set(Screen screen)
    {
        screens.pop().dispose();
        screens.push(screen);
    }

    public void update(float dt)
    {
        screens.peek().update(dt);
    }

    public void render(SpriteBatch batch)
    {
        screens.peek().render(batch);
    }
}
