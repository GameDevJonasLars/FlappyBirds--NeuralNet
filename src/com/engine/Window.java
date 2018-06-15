package com.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.MainGame;
import com.graphics.Oval;
import com.graphics.Rechteck;
import com.graphics.Text;

public class Window extends JPanel {
	private List<Rechteck> rects = new ArrayList<Rechteck>();
	private List<Text> texte = new ArrayList<Text>();
	private List<Oval> ovale = new ArrayList<Oval>();
	private Color background;

	public Window() {
		background = Color.WHITE;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(background);
		g2.fillRect(0, 0, MainGame.WIDTH, MainGame.HEIGHT);
		for (Rechteck rectangle : rects) {
			g2.setColor(new Color(rectangle.getiCol1(), rectangle.getiCol2(), rectangle.getiCol3()));
			g2.fillRect(rectangle.getiX(), rectangle.getiY(), rectangle.getiWidth(), rectangle.getiHeight());
		}
		for (Oval oval : ovale) {
			g2.setColor(new Color(oval.getiCol1(), oval.getiCol2(), oval.getiCol3()));
			g2.fillOval(oval.getiX(), oval.getiY(), oval.getiWidth(), oval.getiHeight());
		}
		for (Text text : texte) {
			g2.setFont(text.getFoFont());
			g2.setColor(Color.BLACK);
			g2.drawString(text.getsText(), text.getiX(), text.getiY());
		}
		

	}

	public int addRect(int x, int y, int width, int height, Color col) {
		rects.add(new Rechteck(x, y, width, height, col));
		return rects.size() - 1;
	}
	public int addOval(int x, int y, int width, int height, Color col) {
		ovale.add(new Oval(x, y, width, height, col));
		return ovale.size() - 1;
	}

	public int addText(String sText, int iX, int iY) {
		texte.add(new Text(sText, iX, iY));
		return texte.size() - 1;
	}

	public int addText(String sText, int iX, int iY, int iScale) {
		texte.add(new Text(sText, iX, iY, iScale));
		return texte.size() - 1;
	}
	public int addText(String sText, int iX, int iY, Font foFont) {
		texte.add(new Text(sText, iX, iY, foFont));
		return texte.size() - 1;
	}

	public List<Rechteck> getRects() {
		return rects;
	}

	public List<Text> getTexte() {
		return texte;
	}

	public List<Oval> getOvale() {
		return ovale;
	}
	

}
