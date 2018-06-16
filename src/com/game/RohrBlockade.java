package com.game;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.engine.Window;
import com.tools.ResourceLoader;

public class RohrBlockade{
	private Window window;
	private int iR�hreOben;
	private int iR�hreUnten;
	private int iVerschieben;
	private int iBird;
	private int iBoden;
	private RohrController rohrController;

	public RohrBlockade(Window window) {
		this.window = window;
		iVerschieben = 3;
		rohrController = null;
	}
	public RohrBlockade(Window window, RohrController rohrController) {
		this.window = window;
		iVerschieben = 3;
		this.rohrController = rohrController;
	}

	public void update() {
		window.getSprites().get(iR�hreOben).mov(-iVerschieben, 0);
		window.getSprites().get(iR�hreUnten).mov(-iVerschieben, 0);
	}
	public void getNames() {
		for (Objekte objekte : ObjektListe.lObjekte) {
			if ("Body".equals(objekte.getsName())) {
				iBird = objekte.getiIndex();
			}
			if ("Boden".equals(objekte.getsName())) {
				iBoden = objekte.getiIndex();
			}
		}
	}

	public void collision() {
		if (new Rectangle(window.getSprites().get(iBird).getiX(), window.getSprites().get(iBird).getiY(),
				window.getSprites().get(iBird).getiWidth(), window.getSprites().get(iBird).getiHeight())
						.intersects(new Rectangle(window.getRects().get(iBoden).getiX(), window.getRects().get(iBoden).getiY(),
								window.getRects().get(iBoden).getiWidth(), window.getRects().get(iBoden).getiHeight()))) {
			if (rohrController != null) {
				rohrController.resetList();
			}
		}
		if (new Rectangle(window.getSprites().get(iBird).getiX(), window.getSprites().get(iBird).getiY(),
				window.getSprites().get(iBird).getiWidth(), window.getSprites().get(iBird).getiHeight()).intersects(
						new Rectangle(window.getSprites().get(iR�hreOben).getiX(), window.getSprites().get(iR�hreOben).getiY(),
								window.getSprites().get(iR�hreOben).getiWidth(), window.getSprites().get(iR�hreOben).getiHeight()))) {
			if (rohrController != null) {
				rohrController.resetList();
			}
			Punkte.iPunkte = 0;
			window.getSprites().get(0).setiY(100);

		}
		if (new Rectangle(window.getSprites().get(iBird).getiX(), window.getSprites().get(iBird).getiY(),
				window.getSprites().get(iBird).getiWidth(), window.getSprites().get(iBird).getiHeight()).intersects(
						new Rectangle(window.getSprites().get(iR�hreUnten).getiX(), window.getSprites().get(iR�hreUnten).getiY(),
								window.getSprites().get(iR�hreUnten).getiWidth(), window.getSprites().get(iR�hreUnten).getiHeight()))) {
			if (rohrController != null) {
				rohrController.resetList();
			}
			Punkte.iPunkte = 0;
			window.getSprites().get(0).setiY(100);
		}
	}

	public void init() {
		try {
			Random rd = new Random();
			int iHeight = rd.nextInt(MainGame.HEIGHT-window.getRects().get(iBoden).getiHeight()-200);
			iR�hreOben = window.addSprite(MainGame.WIDTH ,
					iHeight - ImageIO.read(ResourceLoader.load("R�hre_Oben.png")).getHeight(),
					ImageIO.read(ResourceLoader.load("R�hre_Oben.png")), "R�hreOben");
			iR�hreUnten = window.addSprite(MainGame.WIDTH , iHeight+200, ImageIO.read(ResourceLoader.load("R�hre_Unten.png")),
					"R�hreUnten");
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
