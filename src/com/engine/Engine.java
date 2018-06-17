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
import com.tools.ResourceLoader;
import com.tools.Time;

public abstract class Engine extends Thread {
	protected boolean isRunning;
	public static int FPS_CAP;
	protected Window window;
	protected MouseListenerWin maus;
	protected boolean bWasPressed;
	protected Bird jonas;
	protected RohrController rohrController;
	protected int iTextPunkte;
	protected int iTextHighscore;
	protected boolean bUpdate;

	public Engine(Window window) {
		isRunning = false;
		bWasPressed = false;
		bUpdate = true;
		FPS_CAP = 60;

		this.window = window;
		maus = new MouseListenerWin();
		jonas = new Bird(window, 0);
		rohrController = new RohrController(window);
	}

	public void stopEngine() {
		isRunning = false;
	}
	public void startEngine() {
		isRunning = true;
		this.start();
	}
	

	public void setbUpdate(boolean bUpdate) {
		this.bUpdate = bUpdate;
	}

	public void render() {

		window.repaint();
	}

	public abstract void update();

	public abstract void init();

	public abstract void getNames();

	public abstract void input();

	public void run() {
		long lStartTime = Time.getTime();
		long lZeit = Time.getTime();
		long lZeitFrame = Time.getTime();
		int iFrames = 0;
		init();
		getNames();
		while (isRunning) {
			long lTime = Time.getTime();

			if (lTime - lZeit > (1000000000 / FPS_CAP)) {
				Time.lDelta = lTime - lZeit;
				iFrames++;
				lZeit = lTime;
				input();
				if (bUpdate) {
					update();
				}
				
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
