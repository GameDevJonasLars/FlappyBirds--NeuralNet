package com.game;

import java.awt.Color;

import com.engine.Window;

public class Bird {
	private Window window;
	private int iBody;
	private float fMov;
	public Bird(Window window) {
		this.window = window;
		fMov = 0;
	}
	public void update() {
		fMov += 0.5f;
		window.getOvale().get(iBody).mov(0, (int)fMov);
	}
	public void render() {
		
	}
	public void init() {
		iBody = window.addOval(100, 400, 50, 50, Color.green);
	}
	public void flap() {
		fMov = -15;
	}
}
