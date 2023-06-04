package com.karakas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	private ScreenManager sm;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		sm = new ScreenManager();
		sm.push(new MenuScreen(sm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sm.update(Gdx.graphics.getDeltaTime());
		sm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
