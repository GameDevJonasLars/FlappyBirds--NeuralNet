package com.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game.Bird;
import com.game.MainGame;
import com.tools.Time;

public class Engine extends Thread {
	private boolean isRunning;
	private int FPS_CAP;
	private Window window;
	private MouseListenerWin maus;
	private boolean bWasPressed; 
	private Bird jonas;
	private int iHighscore;

	public Engine(Window window) {
		isRunning = true;
		bWasPressed = false;
		FPS_CAP = 60;
		this.window = window;
		maus = new MouseListenerWin();
		jonas = new Bird(window);
	}

	public void stopEngine() {
		isRunning = false;
	}

	public void render() {
		
		window.repaint();
	}
	
	public void update() {
		jonas.update();
		jonas.collision();
		window.getTexte().get(0).setsText("Punkte: "+jonas.getiPunkte());
		if (jonas.getiPunkte() > iHighscore) {
			iHighscore = jonas.getiPunkte();
		}
		window.getTexte().get(1).setsText("Highscore: "+iHighscore);
	}
	
	public void input() {
		
		if(maus.isbPressed() && !bWasPressed) {
			bWasPressed = true;
			jonas.flap();
		}
		
		
		
		if (!maus.isbPressed()) {
			bWasPressed = false;
		}
	}

	public void initGraph() {
		window.setBackground(Color.CYAN);
		window.addRect(0, MainGame.HEIGHT-200, MainGame.WIDTH*2, 200, Color.GREEN);
		window.addText("Punkte: 0", 800, 50);
		window.addText("Highscore: 0", 800, 80);
		jonas.init();
	}

	public void run() {
		long lStartTime = Time.getTime();
		long lZeit = Time.getTime();
		long lZeitFrame = Time.getTime();
		int iFrames = 0;
		initGraph();
		while (isRunning) {
			long lTime = Time.getTime();
			if (lTime - lZeit > (1000000000 / FPS_CAP)) {
				iFrames++;
				lZeit = lTime;
				input();
				update();
				render();
			}
			if (lTime - lZeitFrame > (1000000000)) {
				MainGame.frame.setTitle(MainGame.TITLE + " FPS: " + iFrames);
				iFrames = 0;
				lZeitFrame = lTime;
			}
		}
	}

}
