package com.karakas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen extends Screen{

    private static final int PIPE_SPACING =125;
    private static final int PIPE_COUNT = 100;

    private BitmapFont font;
    private int score;
    private Bird bird;
    private Texture background;
    private Array<Pipe>pipes;

    public GameScreen(ScreenManager sm) {
        super(sm);
        bird = new Bird(40,250);
        cam.setToOrtho(false, Main.WIDTH/ 2 , Main.HEIGHT / 2);
        background = new Texture(Gdx.files.internal("background.png"));
        pipes = new Array<Pipe>();
        font = new BitmapFont();

        for(int i=1;i<=PIPE_COUNT;i++)
        {
            pipes.add(new Pipe(i *(PIPE_SPACING + Pipe.PIPE_WIDTH)));
        }
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        cam.position.x = bird.getPosition().x + 80;

        for(int i = 0; i < pipes.size; i++)
        {
            Pipe pipe = pipes.get(i);

            if(cam.position.x - (cam.viewportWidth / 2) > pipe.getPosTopPipe().x + pipe.getTopPipe().getWidth())
            {
                pipe.reposition(pipe.getPosTopPipe().x + ((Pipe.PIPE_WIDTH + PIPE_SPACING) * PIPE_COUNT));
            }

            if(bird.getPosition().x > pipe.getPosBotPipe().x)
            {
                score++;
            }

            if(pipe.collides(bird.getBirdEdge()))
            {
                sm.set(new MenuScreen(sm));
            }

        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(background,cam.position.x - (cam.viewportWidth / 2),0);
        batch.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        font.draw(batch,"SCORE: " + score , cam.position.x + 115 ,cam.position.y + 200);
        for(Pipe pipe : pipes)
        {
            batch.draw(pipe.getTopPipe(), pipe.getPosTopPipe().x, pipe.getPosTopPipe().y);
            batch.draw(pipe.getBotPipe(), pipe.getPosBotPipe().x, pipe.getPosBotPipe().y);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        bird.dispose();
        background.dispose();
        font.dispose();
        for(Pipe pipe : pipes)
        {
            pipe.dispose();
        }
    }
}
