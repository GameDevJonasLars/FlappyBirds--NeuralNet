package com.game;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.engine.Window;
import com.tools.ResourceLoader;
import com.tools.Time;

public class RohrBlockade {
	private Window window;
	private int iRöhreOben;
	private int iRöhreUnten;
	private int iBoden;
	private double dAdd;
	private RohrController rohrController;
	private boolean bPassed;

	public RohrBlockade(Window window) {
		this.window = window;
		dAdd = 0;
		rohrController = null;
		bPassed = false;
	}

	public RohrBlockade(Window window, RohrController rohrController) {
		this.window = window;
		this.rohrController = rohrController;
	}

	public void update() {
		dAdd += (int) rohrController.getfVerschieben() * Time.getDelta();
		if (dAdd > 1) {
			window.getSprites().get(iRöhreOben).mov(-(int) dAdd, 0);
			window.getSprites().get(iRöhreUnten).mov(-(int) dAdd, 0);
			dAdd -= (int) dAdd;
		}
		if (!bPassed && 213 > window.getSprites().get(iRöhreOben).getiX()) {
			bPassed = true;
			Punkte.setiPunkteRöhre(Punkte.getiPunkteRöhre() + 1);
			if (Punkte.getiPunkteRöhre() > Punkte.getiHighscoreRöhre()) {
				Punkte.setiHighscoreRöhre(Punkte.getiPunkteRöhre());

			}
		}
	}

	public void getNames() {
		for (Objekte objekte : ObjektListe.lObjekte) {

			if ("Boden".equals(objekte.getsName())) {
				iBoden = objekte.getiIndex();
			}
		}
	}

	public void init() {
		try {
			Random rd = new Random();
			int iHeight = rd.nextInt(MainGame.HEIGHT - 400);
			iRöhreOben = window.addSprite(MainGame.WIDTH,
					iHeight - ImageIO.read(ResourceLoader.load("FlappyBirdRöhreOben.PNG")).getHeight(),
					ImageIO.read(ResourceLoader.load("FlappyBirdRöhreOben.PNG")), "RöhreOben");
			iRöhreUnten = window.addSprite(MainGame.WIDTH, iHeight + 200,
					ImageIO.read(ResourceLoader.load("FlappyBirdRöhreUnten.PNG")), "RöhreUnten");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getiRöhreOben() {
		return iRöhreOben;
	}

	public int getiRöhreUnten() {
		return iRöhreUnten;
	}

}
