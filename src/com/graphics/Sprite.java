package com.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Sprite {
	private int iX;
	private int iY;
	private int iWidth;
	private int iHeight;

	private int iCol1;
	private int iCol2;
	private int iCol3;
	private double dRotate;
	private BufferedImage img;
	private boolean bDraw;

	public Sprite(int iX, int iY, BufferedImage img) {
		this.iX = iX;
		this.iY = iY;
		iWidth = img.getWidth();
		iHeight = img.getHeight();
		this.img = img;
		dRotate = 0;
		bDraw = true;
	}

	public int getiX() {
		return iX;
	}

	public void setiX(int iX) {
		this.iX = iX;
	}

	public int getiY() {
		return iY;
	}

	public void setiY(int iY) {
		this.iY = iY;
	}

	public int getiWidth() {
		return iWidth;
	}

	public void setiWidth(int iWidth) {
		this.iWidth = iWidth;
	}

	public int getiHeight() {
		return iHeight;
	}

	public void setiHeight(int iHeight) {
		this.iHeight = iHeight;
	}

	public void mov(int iX, int iY) {
		this.iX += iX;
		this.iY += iY;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public double getdRotate() {
		return dRotate;
	}

	public void setdRotate(int iDegree) {
		this.dRotate = Math.PI * 2 / 360 * iDegree;
	}

	public boolean isbDraw() {
		return bDraw;
	}

	public void setbDraw(boolean bDraw) {
		this.bDraw = bDraw;
	}

}
