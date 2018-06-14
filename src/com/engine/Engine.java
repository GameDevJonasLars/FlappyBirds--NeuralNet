package com.engine;

import java.awt.Color;
import java.awt.Rectangle;

import com.game.MainGame;
import com.tools.Time;

public class Engine extends Thread {
	private boolean isRunning;
	private int FPS_CAP;
	private Window window;
	int b = 0;

	public Engine(Window window) {
		isRunning = true;
		FPS_CAP = 30;
		this.window = window;
	}

	public void stopEngine() {
		isRunning = false;
	}

	public void render() {
		b++;
		window.getRects().get(0).setiX(b);
		window.repaint();
	}

	public void initGraph() {
		window.setBackground(Color.CYAN);
		window.addRect(100, 100, 400, 200, Color.BLACK);
		// window.addRect(101, 101, 398, 198, Color.WHITE);
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
