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

		TrainingController train = new TrainingController(window, 8, 2, 1);
		train.start();
		//EngineFlappyBird eng = new EngineFlappyBird(window);
		//eng.startGame(1);

		


		
	}
}
