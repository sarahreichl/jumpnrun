package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

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
        // charcter erzeugen (Sarah)
        game.character.updateAndRender(game.batch);
        // Enemies und Wolken erzeugen (Teresa)
        game.enemies.updateAndRender(game.batch);

        game.batch.end();
        System.out.println(game.character.getCharacterY());
//        System.out.println(game.enemies.getEnemyX());
//        System.out.println(game.enemies.getEnemyY());
//        System.out.println(game.character.getCharacterX());

    }


    @Override
    public void dispose() {
        game.batch.dispose();
    }

    @Override
    public void hide() {
        this.dispose();
    }

}

