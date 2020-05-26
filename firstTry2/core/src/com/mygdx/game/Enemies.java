package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Enemies {
    Vector2 enemyPosition;
    Vector2 enemy2Position;
    float enemyWidth = 20.0f;
    float enemyLength = 50.0f;
    float i =  Gdx.graphics.getWidth() - enemyWidth;
    float j = Gdx.graphics.getWidth() - enemyWidth;
    int enemy12 = 0;
    Texture clouds;
    int cloudMove = 0;
    Texture enemy1;
    Texture enemy2;


    public Enemies(){
        enemyPosition = new Vector2(Gdx.graphics.getWidth(), 160.0f);
        enemy2Position = new Vector2(Gdx.graphics.getWidth() , 190.0f);
        clouds = new Texture("clouds.png");
        enemy1 = new Texture("enemy2.png");
        enemy2 = new Texture("enemy3.png");
    }

    public void updateAndRender(SpriteBatch batch){
        movement();

        if(Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/4 - cloudMove < 0 - 300 ){
            cloudMove = 0;
        }

        batch.draw(clouds, Gdx.graphics.getWidth() - cloudMove, (Gdx.graphics.getHeight() - 200), 150, 100);
        cloudMove += 1;

        batch.draw(enemy1, enemyPosition.x, enemyPosition.y, enemyWidth, enemyLength);
        batch.draw(enemy2, enemy2Position.x, enemy2Position.y, enemyWidth, enemyLength);

    }

    //Paddlesbewegen
    public void movement(){

        int x = (int) (Math.random() * 2 +1);

        if (enemy12 != 2 && x == 1) {
            paddlePosition1();
            enemy12 = 1;
            if (enemyPosition.x == 0 - enemyWidth) {
                enemy12 = 0;
            }

        }
        if(enemy12 != 1 && x == 2) {
            paddlePosition2();
            enemy12 = 2;
            if (enemy2Position.x == 0 - enemyWidth) {
                enemy12 = 0;
            }
        }
    }

    //  Einzelne Hindernisse erzeuegen
    public void paddlePosition1(){
        enemyPosition.x = i;
        i -= 5;
        if(i == -5 - enemyWidth){
            i = Gdx.graphics.getWidth() - enemyWidth;
        }
    }
    public void paddlePosition2(){
        enemy2Position.x = j;
        j -= 5;
        if(j < -5 - enemyWidth){
            j = Gdx.graphics.getWidth() - enemyWidth;
        }
    }
}
