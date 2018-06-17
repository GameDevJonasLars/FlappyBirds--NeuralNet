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
import com.game.Punkte;
import com.game.RohrBlockade;
import com.game.RohrController;
import com.tools.Time;

public class Engine extends Thread {
	private boolean isRunning;
	private int FPS_CAP;
	private Window window;
	private MouseListenerWin maus;
	private boolean bWasPressed;
	private Bird jonas;
	private RohrController rohrController;
	private int iTextPunkte;
	private int iTextHighscore;
	private int iBoden;

	public Engine(Window window) {
		isRunning = true;
		bWasPressed = false;
		FPS_CAP = 60;
		this.window = window;
		maus = new MouseListenerWin();
		jonas = new Bird(window);
		rohrController = new RohrController(window);
	}

	public void stopEngine() {
		isRunning = false;
	}

	public void render() {

		window.repaint();
	}

	public void update() {
		jonas.update();
		rohrController.update();
		jonas.collision();
		window.getTexte().get(iTextPunkte).setsText("Punkte: " + Punkte.getiPunkte());
		if (Punkte.getiPunkte() > Punkte.getiHighscore()) {
			Punkte.setiHighscore(Punkte.getiPunkte());
		}
		window.getTexte().get(iTextHighscore).setsText("Highscore: " + Punkte.getiHighscore());
	}

	public void getNames() {
		jonas.getNames();
	}

	public void input() {

		if (maus.isbPressed() && !bWasPressed) {
			bWasPressed = true;
			jonas.flap();
		}

		if (!maus.isbPressed()) {
			bWasPressed = false;
		}
	}

	public void initGraph() {
		window.setBackground(Color.CYAN);
		iBoden = window.addRect(0, MainGame.HEIGHT - 200, MainGame.WIDTH * 2, 200, Color.GREEN, "Boden");
		iTextPunkte = window.addText("Punkte: 0", 800, 50, "TextPunkte");
		iTextHighscore = window.addText("Highscore: 0", 800, 80, "TextHighscore");
		jonas.init();
		Punkte.setiPunkte(0);
		Punkte.setiHighscore(0);
	}

	public void run() {
		long lStartTime = Time.getTime();
		long lZeit = Time.getTime();
		long lZeitFrame = Time.getTime();
		int iFrames = 0;
		initGraph();
		getNames();
		while (isRunning) {
			long lTime = Time.getTime();
			
			if (lTime - lZeit > (1000000000 / FPS_CAP)) {
				Time.lDelta = lTime - lZeit;
				System.out.println(Time.getDelta());
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
