package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    public float enemyX;
    public float enemyY;
    int score = 0;
    BitmapFont scoreFont;
    int speed = 400;
    float timeHelper = 0;
    BitmapFont timeFont;
    float time = 0;

    /**
     * - einfügen der Bilder für Enemies und Wolken im Hintergrund
     */
    public Enemies(){
        enemyPosition = new Vector2(Gdx.graphics.getWidth(), 160.0f);
        enemy2Position = new Vector2(Gdx.graphics.getWidth() , 190.0f);
        clouds = new Texture("clouds4.gif");
        enemy1 = new Texture("enemy2.png");
        enemy2 = new Texture("enemy3.png");

        scoreFont = new BitmapFont();
        scoreFont.setColor(Color.WHITE);
        timeFont = new BitmapFont();
        timeFont.setColor(Color.WHITE);

    }

    /**
     * @param delta
     * @param batch
     */
    public void updateAndRender(float delta, SpriteBatch batch){
        timeHelper += Gdx.graphics.getDeltaTime();
        time += Gdx.graphics.getDeltaTime();
        int timer = (int) Math.floor(time);
        if(timeHelper > 1) {
            if (Math.abs(enemyPosition.x - 105) < 15 || Math.abs(enemy2Position.x - 105) < 15) {
                score++;
                speed += 30;
                timeHelper = 0;
            }
        }
        movement(delta);


        if(Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/4 - cloudMove < 0 - 300 ){
            cloudMove = 0;
        }


        batch.draw(clouds, Gdx.graphics.getWidth() - cloudMove, (Gdx.graphics.getHeight() - 200), 150, 100);
        cloudMove += 1;

        batch.draw(enemy1, enemyPosition.x, enemyPosition.y, enemyWidth, enemyLength);
        batch.draw(enemy2, enemy2Position.x, enemy2Position.y, enemyWidth, enemyLength);
        scoreFont.draw(batch, "score: "+ score, Gdx.graphics.getWidth()-60, Gdx.graphics.getHeight()-scoreFont.getCapHeight());
        timeFont.draw(batch, "time:"+ timer, Gdx.graphics.getWidth()-60, Gdx.graphics.getHeight()-3*scoreFont.getCapHeight());
    }

    //Paddlesbewegen

    /**
     * - betimmt bewegung der enemies und Wolken
     * @param deltaTime
     */
    public void movement(float deltaTime){

        int x = (int) (Math.random()*2 +1);
        if (enemy12 != 2 && x == 1) {
            paddlePosition1(deltaTime);
            enemy12 = 1;
            enemyX = enemyPosition.x;
            enemyY = enemyPosition.y;
            if (enemyPosition.x < 0 - enemyWidth) {
                enemy12 = 0;
            }
        }
        if(enemy12 != 1 && x == 2) {
            paddlePosition2(deltaTime);
            enemy12 = 2;
            enemyX = enemy2Position.x;
            enemyY = enemy2Position.y;
            if (enemy2Position.x < 0 - enemyWidth ) {
                enemy12 = 0;
            }

        }


    }

    //  Einzelne Hindernisse erzeuegen

    /**
     * erzeugt Hindernissse Art 1
     * beschleunigt diese
     * @param deltaTime
     */
    public void paddlePosition1(float deltaTime){
        enemyPosition.x = i;
        i -= speed * deltaTime;
        if(i < -speed ){
            i = Gdx.graphics.getWidth();
        }
    }
    /**
     * erzeugt Hindernissse Art 2
     * beschleunigt diese
     * @param deltaTime
     */
    public void paddlePosition2(float deltaTime){
        enemy2Position.x = j;
        j -= speed * deltaTime;
        if(j < -speed ){
            j = Gdx.graphics.getWidth();
        }
    }

    public float getEnemyX(){
        return enemyX;
    }

    public float getEnemyY(){
        return enemyY;
    }

    public void setEnemyX(float enemyX) {
        this.enemyX = enemyX;
    }

    public void setEnemyY(float enemyY) {
        this.enemyY = enemyY;
    }

    public void setI(float i) {
        this.i = i;
    }

    public void setJ(float j) {
        this.j = j;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

