package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.game.EngineFlappyBird;
import com.game.MainGame;
import com.training.TrainingController;

public class ActionListenerBird implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == MainGame.controller.jbGame) {
			MainGame.controller.frame.remove(MainGame.controller.jpMainMenu);
			MainGame.controller.frame.add(MainGame.controller.jpGame);
			EngineFlappyBird eng = new EngineFlappyBird(MainGame.controller.windowGame, true);
			eng.startGame(1);
			MainGame.controller.frame.repaint();
			MainGame.controller.frame.validate();
		}
		if (ae.getSource() == MainGame.controller.jbAI) {
			MainGame.controller.frame.remove(MainGame.controller.jpMainMenu);
			MainGame.controller.frame.add(MainGame.controller.jpAIGame);
			TrainingController train = new TrainingController(MainGame.controller.windowAI, 20, 2, 1);
			train.start();
			MainGame.controller.frame.repaint();
			MainGame.controller.frame.validate();
		}
		
	}

}
