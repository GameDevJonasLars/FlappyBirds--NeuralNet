package com.gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.engine.Window;
import com.game.MainGame;

public class Objekte {
	public JPanel jpMainMenu;
	public JPanel jpAIGame;
	public JPanel jpGame;
	public JPanel jpAISettings;
	protected JButton jbAI;
	protected JButton jbGame;
	protected Window windowAI;
	protected Window windowGame;

	public Objekte() {
		jpMainMenu = new JPanel();
		windowAI = new Window();
		windowGame = new Window();
		jpAIGame = windowAI;
		jpGame = windowGame;
		jpAISettings = new JPanel();
		
		jbAI = new JButton("KI trainieren");
		jbGame = new JButton("Spielen");
		
		jpMainMenu.setLayout(null);
		jpAISettings.setLayout(null);
		jpAIGame.setLayout(null);
		jpGame.setLayout(null);
		jpMainMenu.add(jbGame);
		jpMainMenu.add(jbAI);

		
		jbAI.addActionListener(new ActionListenerBird());
		jbGame.addActionListener(new ActionListenerBird());
		jbAI.setBounds(MainGame.WIDTH/2-300, MainGame.HEIGHT/2-25, 200, 50);
		jbGame.setBounds(MainGame.WIDTH/2+100, MainGame.HEIGHT/2-25, 200, 50);
		jpMainMenu.repaint();
		jpMainMenu.validate();
	}
}
