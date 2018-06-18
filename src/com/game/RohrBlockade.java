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
	private int iR�hreOben;
	private int iR�hreUnten;
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
			window.getSprites().get(iR�hreOben).mov(-(int) dAdd, 0);
			window.getSprites().get(iR�hreUnten).mov(-(int) dAdd, 0);
			dAdd -= (int) dAdd;
		}
		if (!bPassed && 213 > window.getSprites().get(iR�hreOben).getiX()) {
			bPassed = true;
			Punkte.setiPunkteR�hre(Punkte.getiPunkteR�hre() + 1);
			if (Punkte.getiPunkteR�hre() > Punkte.getiHighscoreR�hre()) {
				Punkte.setiHighscoreR�hre(Punkte.getiPunkteR�hre());

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
			iR�hreOben = window.addSprite(MainGame.WIDTH,
					iHeight - ImageIO.read(ResourceLoader.load("FlappyBirdR�hreOben.PNG")).getHeight(),
					ImageIO.read(ResourceLoader.load("FlappyBirdR�hreOben.PNG")), "R�hreOben");
			iR�hreUnten = window.addSprite(MainGame.WIDTH, iHeight + 200,
					ImageIO.read(ResourceLoader.load("FlappyBirdR�hreUnten.PNG")), "R�hreUnten");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getiR�hreOben() {
		return iR�hreOben;
	}

	public int getiR�hreUnten() {
		return iR�hreUnten;
	}

}
