package com.game;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Window;

public class RohrBlockade {
	private Window window;
	private int iR�hreOben;
	private int iR�hreUnten;
	private int iVerschieben;

	public RohrBlockade(Window window) {
		this.window = window;
		iVerschieben = 3;
	}

	public void update() {
		window.getSprites().get(iR�hreOben).mov(-iVerschieben, 0);
		window.getSprites().get(iR�hreUnten).mov(-iVerschieben, 0);
	}

	public void init() {
		try {
			iR�hreOben = window.addSprite(MainGame.WIDTH - 100, 300-ImageIO.read(new File("res/R�hre_Oben.png")).getHeight(), ImageIO.read(new File("res/R�hre_Oben.png")));
			iR�hreUnten = window.addSprite(MainGame.WIDTH - 100, 500, ImageIO.read(new File("res/R�hre_Unten.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
