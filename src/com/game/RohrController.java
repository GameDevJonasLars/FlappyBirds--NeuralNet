package com.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.engine.Window;
import com.tools.ResourceLoader;
import com.tools.Time;

public class RohrController {
	public static List<RohrBlockade> rohre;
	private Window window;
	private float fTime;
	private int iBoden;
	private double dAdd;
	private double dÜber;
	private float fVerschieben;
	private int iVal;

	public RohrController(Window window) {
		rohre = new ArrayList<RohrBlockade>();
		this.window = window;
		fTime = 0;
		dAdd = 0;
		dÜber = 0;
		fVerschieben = 3;
		iVal = 0;
		try {
			iBoden = window.addSprite(0, MainGame.HEIGHT - 200, ImageIO.read(ResourceLoader.load("FlappyBirdBoden.PNG")), "Boden");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update() {
		if (Time.getDelta() < 1 || Time.getDelta() == 1) {
			//fVerschieben += 0.0005;
			dAdd += Time.getDelta();
			if (dAdd > 1) {
				iVal += (int)fVerschieben;
				window.getSprites().get(iBoden).setiX(-iVal);
			}
			

		}
		if (Time.getDelta() > 1) {
			dÜber += Time.getDelta();
			for (int i = 0; dÜber > 1; i++) {
				//fVerschieben += 0.0005;
				iVal += (int)fVerschieben;
				window.getSprites().get(iBoden).setiX(-iVal);
				dÜber--;
			}
		}
		if (window.getSprites().get(iBoden).getiX() < -95) {
			window.getSprites().get(iBoden).setiX(0);
			iVal = 0;
		}
		fTime += Time.getDelta();
		if (rohre.size() == 0) {
			neueRoehre();
		}
		if (fTime > 200-(int)fVerschieben*20) {
			neueRoehre();
			fTime = 0;
		}
		for (RohrBlockade rohrBlockade : rohre) {
			rohrBlockade.update();
		}
	}

	public void neueRoehre() {
		rohre.add(new RohrBlockade(window, this));
		rohre.get(rohre.size() - 1).init();
		rohre.get(rohre.size() - 1).getNames();
	}

	public void resetList() {
		for (RohrBlockade rohrBlockade : rohre) {
			window.getSprites().get(rohrBlockade.getiRöhreOben()).setbDraw(false);
			window.getSprites().get(rohrBlockade.getiRöhreUnten()).setbDraw(false);
		}
		fTime = 0;
		rohre = new ArrayList<RohrBlockade>();
	}
	public float getfVerschieben() {
		return fVerschieben;
	}
	public void setfVerschieben(float fVerschieben) {
		this.fVerschieben = fVerschieben;
	}
	
}
