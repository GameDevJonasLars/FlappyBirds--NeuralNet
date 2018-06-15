package com.game;

import java.awt.Color;

import com.engine.Window;

public class Bird {
	private Window window;
	private int iBody;
	private int iEye1;
	private float fMov;
	public Bird(Window window) {
		this.window = window;
		fMov = 0;
	}
	public void update() {
		fMov += 0.5f;
		window.getOvale().get(iBody).mov(0, (int)fMov);
		window.getOvale().get(iEye1).mov(0, (int)fMov);
	}
	public void render() {
		
	}
	public void init() {
		iBody = window.addOval(100, 400, 70, 50, Color.green);
		iEye1 = window.addOval(150, 410, 20, 20, Color.white);
	}
	public void flap() {
		fMov = -15;
	}
}
