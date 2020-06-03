package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {

    public static final int DEFAULT_SPEED = 80;
    public static final int ACCELERATION = 50;
    public static final int GOAL_REACH_ACCELERATION = 200;

    Texture backgroundImage;
    float x1, x2;
    int speed;
    int goalSpeed;
    float imageScale;

    public ScrollingBackground() {
        backgroundImage = new Texture(Gdx.files.internal("background11a.jpg"));
        x1 = 0;
        x2 = Gdx.graphics.getWidth();
        imageScale = 1;
        speed = 0;
        goalSpeed = DEFAULT_SPEED;
    }

    public void updateAndRender(float deltaTime, SpriteBatch batch) {
        if (speed < goalSpeed) {
            speed += GOAL_REACH_ACCELERATION * deltaTime;
            if (speed > goalSpeed) {
                speed = goalSpeed;
            }
        } else if (speed > goalSpeed) {
            speed -= GOAL_REACH_ACCELERATION * deltaTime;
            if (speed < goalSpeed) {
                speed = goalSpeed;
            }
        }
        x1 -= speed * deltaTime;
        x2 -= speed * deltaTime;

        //Bild ganz links => soll wieder links erscheinen
        if (x1 + Gdx.graphics.getWidth() * imageScale <= 0) {
            x1 = x2 + Gdx.graphics.getWidth() * imageScale;
        }
        if (x2 + Gdx.graphics.getWidth() * imageScale <= 0) {
            x2 = x1 + Gdx.graphics.getWidth() * imageScale;
        }
        batch.draw(backgroundImage, x1, 0, Gdx.graphics.getWidth() * imageScale, Gdx.graphics.getHeight());
        batch.draw(backgroundImage, x2, 0, Gdx.graphics.getWidth() * imageScale, Gdx.graphics.getHeight());
    }


    public void resize(int width, int height) {
        imageScale = height / backgroundImage.getHeight();
    }

    public void setSpeed(int goalSpeed) {
        this.goalSpeed = goalSpeed;
    }
}

