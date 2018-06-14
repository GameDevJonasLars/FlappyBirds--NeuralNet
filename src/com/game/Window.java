package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.graphics.Rechteck;

public class Window extends JPanel {
	private List<Rechteck> rects = new ArrayList<Rechteck>();
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

	}

	public int addRect(int x, int y, int width, int height, Color col) {
		rects.add(new Rechteck(x, y, width, height, col));
		return rects.size() - 1;
	}

	public List<Rechteck> getRects() {
		return rects;
	}

}
