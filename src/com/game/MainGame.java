package com.game;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.engine.Engine;
import com.engine.Frame;
import com.engine.Window;
import com.tools.ResourceLoader;
import com.training.TrainingController;

public class MainGame {
	public static int WIDTH = 1600;
	public static int HEIGHT = 900;
	public static String TITLE = "Flappy Birds";
	public static Frame frame;

	public static void main(String[] args) {
		Window window = new Window();
		frame = new Frame();
		frame.add(window);
		try {
			frame.setIconImage(ImageIO.read(ResourceLoader.load("images.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

<<<<<<< HEAD
<<<<<<< HEAD
		TrainingController train = new TrainingController(window, 9, 2, 1);
=======
		TrainingController train = new TrainingController(window, 5, 3, 1);
>>>>>>> 587163ddd2505068ad003f02180e17cbcf7d26c2
=======
		TrainingController train = new TrainingController(window, 8, 2, 1);
>>>>>>> 2c80f05adc3848b7e854fcc7feb754015da7dc7a
		train.start();
		//EngineFlappyBird eng = new EngineFlappyBird(window);
		//eng.startGame(1);

		


		
	}
}
