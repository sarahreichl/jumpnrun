package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Rules implements Screen {
    private Stage stage;
    private Game game;

    public Rules(MyGdxGame game){
        this.game = game;
        stage = new Stage();
        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        Label rules = new Label("Press W to go up and S to go down, if you want to leave, press Escape :)", font);
        table.add(rules).pad(200,0,0,0);
        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.draw();
        if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            game.setScreen(new startScreen((MyGdxGame) game));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if(Gdx.input.justTouched()){
            game.setScreen(new GameScreen((MyGdxGame) game));
        }
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
