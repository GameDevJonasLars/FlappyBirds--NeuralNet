package com.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.MainGame;
import com.graphics.Oval;
import com.graphics.Rechteck;
import com.graphics.Sprite;
import com.graphics.Text;

public class Window extends JPanel {
	private List<Rechteck> rects = new ArrayList<Rechteck>();
	private List<Text> texte = new ArrayList<Text>();
	private List<Oval> ovale = new ArrayList<Oval>();
	private List<Sprite> sprites = new ArrayList<Sprite>();
	private Color background;
	int b = 0;

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

			g2.translate(rectangle.getiX(), rectangle.getiY());
			g2 = (Graphics2D) g.create();
			g2.rotate(rectangle.getdRotate());
			g2.setColor(new Color(rectangle.getiCol1(), rectangle.getiCol2(), rectangle.getiCol3()));
			g2.fillRect(0-rectangle.getiWidth()/2, 0-rectangle.getiHeight()/2, rectangle.getiWidth(), rectangle.getiHeight());
			g2.dispose();
			g2 = (Graphics2D) g;
			g2.translate(-rectangle.getiX(), -rectangle.getiY());


		}
		for (Sprite sprite : sprites) {

			g2.translate(sprite.getiX(), sprite.getiY());
			g2 = (Graphics2D) g.create();
			g2.rotate(sprite.getdRotate());
			g2.drawImage(sprite.getImg() ,null , 0-sprite.getiWidth()/2, 0-sprite.getiHeight()/2);
			g2.dispose();
			g2 = (Graphics2D) g;
			g2.translate(-sprite.getiX(), -sprite.getiY());


		}

		for (Text text : texte) {

			g2.translate(text.getiX(), text.getiY());
			g2 = (Graphics2D) g.create();
			g2.rotate(text.getdRotate());
			g2.setFont(text.getFoFont());
			g2.setColor(Color.BLACK);
			g2.drawString(text.getsText(), 0, 0);
			g2.dispose();
			g2 = (Graphics2D) g;
			g2.translate(-text.getiX(), -text.getiY());


		}
		for (Oval oval : ovale) {

			g2.translate(oval.getiX(), oval.getiY());
			g2 = (Graphics2D) g.create();
			g2.rotate(oval.getdRotate());
			g2.setColor(new Color(oval.getiCol1(), oval.getiCol2(), oval.getiCol3()));
			g2.fillOval(0-oval.getiWidth()/2, 0-oval.getiHeight()/2, oval.getiWidth(), oval.getiHeight());
			g2.dispose();
			g2 = (Graphics2D) g;
			g2.translate(-oval.getiX(), -oval.getiY());


		}

	}

	public int addRect(int x, int y, int width, int height, Color col) {
		rects.add(new Rechteck(x, y, width, height, col));
		return rects.size() - 1;
	}
	public int addSprite(int iX, int iY, BufferedImage img) {
		sprites.add(new Sprite(iX, iY, img));
		return sprites.size() - 1;
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

	public List<Sprite> getSprites() {
		return sprites;
	}
	

}
