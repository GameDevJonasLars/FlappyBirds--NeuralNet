package com.engine;

import javax.swing.JFrame;

import com.game.MainGame;

public class Frame extends JFrame {
	public Frame() {
		super.setTitle(MainGame.TITLE);
		super.setSize(MainGame.WIDTH, MainGame.HEIGHT);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setResizable(false);
		super.addMouseListener(new MouseListenerWin());
	}
}
