package com.game;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Engine;
import com.engine.Window;
import com.tools.ResourceLoader;

public class EngineFlappyBird extends Engine {

	public EngineFlappyBird(Window window) {
		super(window);
		super.run();
	}

	@Override
	public void update() {
		jonas.update();
		rohrController.update();
		jonas.collision();
		window.getTexte().get(iTextPunkte).setsText("Punkte: " + Punkte.getiPunkteRöhre());
		if (Punkte.getiPunkte() > Punkte.getiHighscore()) {
			Punkte.setiHighscore(Punkte.getiPunkte());
		}
		window.getTexte().get(iTextHighscore).setsText("Highscore: " + Punkte.getiHighscoreRöhre());
	}

	@Override
	public void initGraph() {
		window.setBackground(Color.CYAN);
		try {
			window.addSprite(0,
					-ImageIO.read(ResourceLoader.load("FlappyBirdHintergrund.PNG")).getHeight()
							+ (MainGame.HEIGHT - 200),
					ImageIO.read(ResourceLoader.load("FlappyBirdHintergrund.PNG")), "Hintergrund");
		} catch (IOException e) {
			e.printStackTrace();
		}
		iTextPunkte = window.addText("Punkte: 0", 800, 50, "TextPunkte");
		iTextHighscore = window.addText("Highscore: 0", 800, 80, "TextHighscore");
		jonas.init();

		Punkte.setiPunkte(0);
		Punkte.setiHighscore(0);

	}

	@Override
	public void getNames() {
		jonas.getNames();

	}

	@Override
	public void input() {
		if (maus.isbPressed() && !bWasPressed) {
			bWasPressed = true;
			jonas.flap();
		}

		if (!maus.isbPressed()) {
			bWasPressed = false;
		}

	}

}
