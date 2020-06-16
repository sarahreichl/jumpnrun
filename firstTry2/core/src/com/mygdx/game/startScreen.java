package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class startScreen implements Screen  {
    private Stage stage;
    private Game game;

    Sound music;

    /**
     * - erstellt Startscreen
     * - erstellt Startbutton
     * @param game
     */
    public startScreen(MyGdxGame game){
        this.game = game;
        stage = new Stage();
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        Label playText = new Label("PLAY", font);
        playText.setFontScale(3);
        table.add(playText).expandX();
        stage.addActor(table);
    }
    @Override
    public void render(float delta) {

        if(Gdx.input.justTouched()){
            music = Gdx.audio.newSound(Gdx.files.internal("music.mp3"));
            //music.setLooping(true);
            music.loop();
            //sound.dispose();

            game.setScreen(new GameScreen((MyGdxGame) game));
        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }
    @Override
    public void show() {

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
