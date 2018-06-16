package com.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Window;
import com.graphics.Rechteck;
import com.tools.ResourceLoader;

public class Bird {
	private Window window;
	private int iBody;
	private int iBoden;
	private float fMov;

	public Bird(Window window) {
		this.window = window;
		fMov = 0;
	}

	public void update() {
		fMov += 0.5f;
		window.getSprites().get(iBody).mov(0, (int) fMov);
		if (fMov > 0) {
			window.getSprites().get(iBody).setdRotate(10);
		} else if (fMov < 0) {
			window.getSprites().get(iBody).setdRotate(350);
		} else if (fMov == 0) {
			window.getSprites().get(iBody).setdRotate(0);
		}
		Punkte.iPunkte++;
	}

	public void render() {

	}
	public void getNames() {
		for (Objekte objekte : ObjektListe.lObjekte) {
			if ("Boden".equals(objekte.getsName())) {
				iBoden = objekte.getiIndex();
			}
		}
	}

	public void collision() {
		if (new Rectangle(window.getSprites().get(iBody).getiX(), window.getSprites().get(iBody).getiY(),
				window.getSprites().get(iBody).getiWidth(), window.getSprites().get(iBody).getiHeight())
						.intersects(new Rectangle(window.getRects().get(iBoden).getiX(), window.getRects().get(iBoden).getiY(),
								window.getRects().get(iBoden).getiWidth(), window.getRects().get(iBoden).getiHeight()))) {
			window.getSprites().get(iBody).setiY(100);
			fMov = 0;
			Punkte.iPunkte = 0;
		}
	}

	public void init() {
		try {
			iBody = window.addSprite(200, 100, ImageIO.read(ResourceLoader.load("DisabledBird.png")), "Body");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void flap() {
		fMov = -10;
	}

}
