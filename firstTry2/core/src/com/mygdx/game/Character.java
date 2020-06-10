package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


public class Character {
    float y;
    public float characterY;
    public float characterX;
    SpriteBatch batch;
    Texture img;
    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;

    /**
     * - legt y Koordinate fest
     * - unterteilt Bild in 4 TextureRegions die in Array gespeichert werden und durchwechseln
     */
    public Character(){

        this.y = 175;

        batch = new SpriteBatch();
        //setScreen(new PlayScreen(this));
        img = new Texture("bat5.png");

        TextureRegion[][] tmpFrames = TextureRegion.split(img, 215, 185);

        animationFrames = new TextureRegion[4];
        int index = 0;
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                animationFrames[index++] = tmpFrames[i][j];
            }
        }

        animation = new Animation(1f/4f, animationFrames);



    }

    /**
     * - Mit dieser Methode macht die Steurung des Characters (y-Achse) möglich
     * - Mittels: pfeiltasten
     * @param batch
     */
    public void updateAndRender(SpriteBatch batch){
        final int HEIGHT = Gdx.graphics.getHeight();
        final int WIDTH = Gdx.graphics.getWidth();
        elapsedTime+=Gdx.graphics.getRawDeltaTime();

        int x = WIDTH/2 - 215;

        //Cleart Bildschirm
        //Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)||Gdx.input.isKeyPressed(Input.Keys.W)){
            if(HEIGHT-275 > y) {
                y += 5f;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)||Gdx.input.isKeyPressed(Input.Keys.S)){
            if(y>135){
                y -= 5f;
            }
        }
        characterY = y;
        characterX = x;

        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), x, y, 50, 50);

    }

    public float getCharacterY(){
        return characterY;
    }
    public float getCharacterX(){
        return characterX;
    }

}
