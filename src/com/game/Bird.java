package com.game;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Window;

public class Bird {
	private Window window;
	private int iBody;
	private int iPunkte;
	private float fMov;
	public Bird(Window window) {
		this.window = window;
		fMov = 0;
	}
	public void update() {
		fMov += 0.5f;
		window.getSprites().get(iBody).mov(0, (int)fMov);
		if (fMov > 0) {
			window.getSprites().get(iBody).setdRotate(10);
		}
		else if (fMov < 0) {
			window.getSprites().get(iBody).setdRotate(350);
		}
		else if (fMov == 0) {
			window.getSprites().get(iBody).setdRotate(0);
		}
		iPunkte++;
	}
	public void render() {
		
	}
	
	public void collision() {
		if (window.getSprites().get(iBody).getiY()>700-window.getSprites().get(iBody).getiHeight()/2) {
			window.getSprites().get(iBody).setiY(100);
			fMov = 0;
			iPunkte = 0;
		}
	}
	public void init() {
		try {
			iBody = window.addSprite(200, 100, ImageIO.read(new File("res/DisabledBird.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void flap() {
		fMov = -15;
	}
	public int getiPunkte() {
		return iPunkte;
	}
	
}
