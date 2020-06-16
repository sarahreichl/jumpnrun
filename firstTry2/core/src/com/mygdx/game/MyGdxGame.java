package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends Game {

	public static MyGdxGame INSTANCE;
	public ScrollingBackground scrollingBackground;
	public Enemies enemies;
	public Character character;
	public SpriteBatch batch;

	Sound music;

	/**
	 * Methode die:
	 * - scrollingBackground erstellt
	 * - enemies generiert
	 * - character generiert
	 * - spielt musik
	 */
	@Override
	public void create () {

		batch = new SpriteBatch();
		this.setScreen(new startScreen(this));
		this.scrollingBackground = new ScrollingBackground();
		this.enemies = new Enemies();
		this.character = new Character();
	}

	@Override
	public void render(){
		super.render();
	}

	@Override
	public void resize(int width, int height){
		this.scrollingBackground.resize(width, height);
		super.resize(width, height);
	}

	@Override
	public void dispose(){
		batch.dispose();
	}

}
