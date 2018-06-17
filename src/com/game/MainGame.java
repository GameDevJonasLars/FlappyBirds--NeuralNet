package com.game;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.engine.Engine;
import com.engine.Frame;
import com.engine.Window;

public class MainGame {
	public static int WIDTH = 1600;
	public static int HEIGHT = 900;
	public static String TITLE = "Flappy Birds";
	public static Frame frame;

	public static void main(String[] args) {
		Window window = new Window();
		Engine eng = new Engine(window);
		eng.start();
		frame = new Frame();
		frame.add(window);
	}
}
