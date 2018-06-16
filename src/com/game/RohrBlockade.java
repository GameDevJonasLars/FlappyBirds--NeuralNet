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
	private int iRöhreOben;
	private int iRöhreUnten;
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
		window.getSprites().get(iRöhreOben).mov(-iVerschieben, 0);
		window.getSprites().get(iRöhreUnten).mov(-iVerschieben, 0);
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
						new Rectangle(window.getSprites().get(iRöhreOben).getiX(), window.getSprites().get(iRöhreOben).getiY(),
								window.getSprites().get(iRöhreOben).getiWidth(), window.getSprites().get(iRöhreOben).getiHeight()))) {
			if (rohrController != null) {
				rohrController.resetList();
			}
			Punkte.iPunkte = 0;
			window.getSprites().get(0).setiY(100);

		}
		if (new Rectangle(window.getSprites().get(iBird).getiX(), window.getSprites().get(iBird).getiY(),
				window.getSprites().get(iBird).getiWidth(), window.getSprites().get(iBird).getiHeight()).intersects(
						new Rectangle(window.getSprites().get(iRöhreUnten).getiX(), window.getSprites().get(iRöhreUnten).getiY(),
								window.getSprites().get(iRöhreUnten).getiWidth(), window.getSprites().get(iRöhreUnten).getiHeight()))) {
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
			iRöhreOben = window.addSprite(MainGame.WIDTH ,
					iHeight - ImageIO.read(ResourceLoader.load("Röhre_Oben.png")).getHeight(),
					ImageIO.read(ResourceLoader.load("Röhre_Oben.png")), "RöhreOben");
			iRöhreUnten = window.addSprite(MainGame.WIDTH , iHeight+200, ImageIO.read(ResourceLoader.load("Röhre_Unten.png")),
					"RöhreUnten");
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
