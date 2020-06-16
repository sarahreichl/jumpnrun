package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
    MyGdxGame game;


    public GameScreen(MyGdxGame game) {
        this.game = game;
    }



    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glClearColor(0, 0, 0, 1);

        game.batch.begin();

        // scrolling Background erzeugen (Teresa)
        game.scrollingBackground.updateAndRender(delta, game.batch);
        // character erzeugen (Sarah)
        game.character.updateAndRender(game.batch);
        // Enemies und Wolken erzeugen (Teresa)
        game.enemies.updateAndRender(delta, game.batch);

        game.batch.end();

//      Death Screen (Teresa & Julia)
        if(Math.abs(game.enemies.getEnemyY()-game.character.getCharacterY()) < 30 && Math.abs(game.enemies.getEnemyX()-game.character.getCharacterX()) < 30){
            game.enemies.setI(Gdx.graphics.getWidth());
            game.enemies.setJ(Gdx.graphics.getWidth());
            game.enemies.setSpeed(400);
            game.enemies.setEnemyX(Gdx.graphics.getWidth());
            game.enemies.setEnemyY(Gdx.graphics.getWidth());
            game.scrollingBackground.setUpdateSpeed(0);
            game.enemies.setTime(0);
            game.setScreen(new endScreen(game));


        }



    }


    @Override
    public void dispose() {

    }

    @Override
    public void hide() {
        this.dispose();
    }

}

