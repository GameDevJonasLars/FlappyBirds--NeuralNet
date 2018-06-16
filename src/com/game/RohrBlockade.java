package com.game;

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

	public void init() {
		try {
			iRöhreOben = window.addSprite(MainGame.WIDTH - 100, 300-ImageIO.read(new File("res/Röhre_Oben.png")).getHeight(), ImageIO.read(new File("res/Röhre_Oben.png")));
			iRöhreUnten = window.addSprite(MainGame.WIDTH - 100, 500, ImageIO.read(new File("res/Röhre_Unten.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
