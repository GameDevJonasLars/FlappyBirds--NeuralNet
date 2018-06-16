package com.game;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Window;

public class RohrBlockade {
	private Window window;
	private int iRöhreOben;
	private int iRöhreUnten;
	private int iVerschieben;

	public RohrBlockade(Window window) {
		this.window = window;
		iVerschieben = 3;
	}

	public void update() {
		window.getSprites().get(iRöhreOben).mov(-iVerschieben, 0);
		window.getSprites().get(iRöhreUnten).mov(-iVerschieben, 0);
	}

	public void collision() {
		if (new Rectangle(window.getSprites().get(0).getiX(), window.getSprites().get(0).getiY(),
				window.getSprites().get(0).getiWidth(), window.getSprites().get(0).getiHeight())
						.intersects(new Rectangle(window.getRects().get(0).getiX(), window.getRects().get(0).getiY(),
								window.getRects().get(0).getiWidth(), window.getRects().get(0).getiHeight()))) {
			window.getSprites().get(iRöhreOben).setiX(MainGame.WIDTH - 100);
			window.getSprites().get(iRöhreUnten).setiX(MainGame.WIDTH - 100);
		}
		if (new Rectangle(window.getSprites().get(0).getiX(), window.getSprites().get(0).getiY(),
				window.getSprites().get(0).getiWidth(), window.getSprites().get(0).getiHeight()).intersects(
						new Rectangle(window.getSprites().get(2).getiX(), window.getSprites().get(2).getiY(),
								window.getSprites().get(2).getiWidth(), window.getSprites().get(2).getiHeight()))) {
			window.getSprites().get(iRöhreOben).setiX(MainGame.WIDTH - 100);
			window.getSprites().get(iRöhreUnten).setiX(MainGame.WIDTH - 100);
			Punkte.iPunkte = 0;
			window.getSprites().get(0).setiY(100);

		}
		if (new Rectangle(window.getSprites().get(0).getiX(), window.getSprites().get(0).getiY(),
				window.getSprites().get(0).getiWidth(), window.getSprites().get(0).getiHeight()).intersects(
						new Rectangle(window.getSprites().get(1).getiX(), window.getSprites().get(1).getiY(),
								window.getSprites().get(1).getiWidth(), window.getSprites().get(1).getiHeight()))) {

			window.getSprites().get(iRöhreOben).setiX(MainGame.WIDTH - 100);
			window.getSprites().get(iRöhreUnten).setiX(MainGame.WIDTH - 100);
			Punkte.iPunkte = 0;
			window.getSprites().get(0).setiY(100);
		}
	}

	public void init() {
		try {
			iRöhreOben = window.addSprite(MainGame.WIDTH - 100,
					300 - ImageIO.read(new File("res/Röhre_Oben.png")).getHeight(),
					ImageIO.read(new File("res/Röhre_Oben.png")));
			iRöhreUnten = window.addSprite(MainGame.WIDTH - 100, 500, ImageIO.read(new File("res/Röhre_Unten.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
