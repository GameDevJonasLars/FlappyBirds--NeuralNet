package com.game;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.engine.Engine;
import com.engine.Window;
import com.tools.ResourceLoader;

public class EngineFlappyBird extends Engine {
	public List<Bird> birds;
	public int iGeneration;
	public int iV�gel;
	public boolean spielen;

	public EngineFlappyBird(Window window, boolean spielen) {
		super(window);
		this.spielen = spielen;
		birds = new ArrayList<Bird>();

	}

	@Override
	public void update() {
		rohrController.update();
		for (Bird bird : birds) {
			bird.update();
		}

		for (Bird bird : birds) {
			bird.collision();
		}
		window.getTexte().get(iTextPunkte).setsText("Punkte: " + Punkte.getiPunkteR�hre());
		if (Punkte.getiPunkte() > Punkte.getiHighscore()) {
			Punkte.setiHighscore(Punkte.getiPunkte());
		}
		boolean restartGame = true;
		for (Bird bird : birds) {
			if (bird.isbAlive()) {
				restartGame = false;
				break;
			}
		}
		if (restartGame&&spielen) {
			restartGame();
		}
		window.getTexte().get(iTextHighscore).setsText("Highscore: " + Punkte.getiHighscoreR�hre());
	}

	@Override
	public void init() {
		window.setBackground(Color.CYAN);
		try {
			window.addSprite(0,
					-ImageIO.read(ResourceLoader.load("FlappyBirdHintergrund.PNG")).getHeight()
							+ (MainGame.HEIGHT - 200),
					ImageIO.read(ResourceLoader.load("FlappyBirdHintergrund.PNG")), "Hintergrund");
		} catch (IOException e) {
			e.printStackTrace();
		}
		iTextPunkte = window.addText("Punkte: 0", 800, 50, "TextPunkte",1);
		iTextHighscore = window.addText("Highscore: 0", 800, 80, "TextHighscore",1);
		iGeneration = window.addText("Generation: 1", 800, 110, "TextGeneration",1);
		iV�gel = window.addText("Lebende V�gel:", 800, 140, "V�gel",1);
		for (Bird bird : birds) {
			bird.init();
		}

		Punkte.setiPunkte(0);
		Punkte.setiHighscore(0);

	}

	@Override
	public void getNames() {
		for (Bird bird : birds) {
			bird.getNames();
		}

	}

	@Override
	public void input() {
		if (maus.isbPressed() && !bWasPressed && spielen) {
			bWasPressed = true;
			for (Bird bird : birds) {
				bird.flap();
			}
		}

		if (!maus.isbPressed()) {
			bWasPressed = false;
		}

	}

	public void restartGame() {
		rohrController.resetList();
		for (Bird bird : birds) {
			int n = 0;
			for (Objekte obj : ObjektListe.lObjekte) {
				if (obj.getsName().equals("Body" + bird.getiIndex())) {
					n = obj.getiIndex();
					break;
				}
			}
			window.getSprites().get(n).setiY(MainGame.HEIGHT / 2 - 200);
			window.getSprites().get(n).setiX(300);
			bird.setbAlive(true);
			bird.setfWinkel(0);
			Punkte.setiPunkte(0);
			Punkte.setiPunkteR�hre(0);
		}
	}

	public void startGame(int iV�gel) {
		for (int i = 0; i < iV�gel; i++) {
			birds.add(new Bird(window, i));
		}
		super.startEngine();
	}

}
