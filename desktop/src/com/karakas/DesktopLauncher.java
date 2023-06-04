package com.karakas;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.karakas.Main;



public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(Main.WIDTH,Main.HEIGHT);
		config.setTitle("Flappy Bird");
		new Lwjgl3Application(new Main(), config);
	}
}
