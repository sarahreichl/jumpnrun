package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled = true;
//		config.fullscreen = true;
		config.title = "Flying Bat";
		config.addIcon("badLogic.jpg", Files.FileType.Internal);
		new LwjglApplication(new MyGdxGame(), config);
	}
}
