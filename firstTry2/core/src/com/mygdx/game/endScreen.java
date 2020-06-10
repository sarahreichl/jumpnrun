package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class endScreen implements Screen {
    private Stage stage;
    private Game game;

    /**
     * - legt das design des Endgames fest
     * - generiert button zum wiederholen
     * @param game
     */
    public endScreen(MyGdxGame game) {
        this.game = game;
        stage = new Stage();
        Label.LabelStyle font1 = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        Table table = new Table();
        table.center();
        table.setFillParent(true);
        Label gameOverText = new Label("YOU DIED", font1);
        Label playAgain = new Label("Play again", font1);
        Label scoreLabel = new Label("Your Score: " + game.enemies.getScore(), font1);
        gameOverText.setFontScale(3);

        table.add(gameOverText).expandX();
        table.row();
        table.add(scoreLabel).expandX();
        table.row();
        table.add(playAgain).expandX().padTop(10);
        stage.addActor(table);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            game.setScreen(new GameScreen((MyGdxGame) game));
            ((MyGdxGame) game).enemies.setScore(0);
        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
