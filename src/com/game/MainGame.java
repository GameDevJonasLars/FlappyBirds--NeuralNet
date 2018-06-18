package com.game;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.engine.Controller;
import com.engine.Engine;
import com.engine.Frame;
import com.engine.Window;
import com.tools.ResourceLoader;
import com.training.TrainingController;

public class MainGame {
	public static int WIDTH = 1600;
	public static int HEIGHT = 900;
	public static String TITLE = "Flappy Birds";
	public static Controller controller;

	public static void main(String[] args) {
		controller = new Controller("images.jpg");
		

		//TrainingController train = new TrainingController(window, 20, 2, 1);
		//train.start();
		//EngineFlappyBird eng = new EngineFlappyBird(window);
		//eng.startGame(1);

		


		
	}
}
