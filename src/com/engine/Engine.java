package com.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;

import com.game.MainGame;
import com.tools.Time;

public class Engine extends Thread {
	private boolean isRunning;
	private int FPS_CAP;
	private Window window;
	private MouseListenerWin maus;
	private boolean bWasPressed; 
	float b = 0;

	public Engine(Window window) {
		isRunning = true;
		bWasPressed = false;
		FPS_CAP = 60;
		this.window = window;
		maus = new MouseListenerWin();
	}

	public void stopEngine() {
		isRunning = false;
	}

	public void render() {
		b += 0.5f;
		window.getOvale().get(0).mov(0, (int)b);
		window.repaint();
	}
	
	public void update() {
		
	}
	
	public void input() {
		
		if(maus.isbPressed() && !bWasPressed) {
			bWasPressed = true;
			b = -15;
		}
		
		
		
		if (!maus.isbPressed()) {
			bWasPressed = false;
		}
	}

	public void initGraph() {
		window.setBackground(Color.CYAN);
		window.addOval(100, 100, 50, 50, Color.BLACK);
		window.addText("Hallo", 0, 50, 100);
	}

	public void run() {
		long lStartTime = Time.getTime();
		long lZeit = Time.getTime();
		long lZeitFrame = Time.getTime();
		int iFrames = 0;
		initGraph();
		while (isRunning) {
			update();
			long lTime = Time.getTime();
			if (lTime - lZeit > (1000000000 / FPS_CAP)) {
				iFrames++;
				lZeit = lTime;
				input();
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
