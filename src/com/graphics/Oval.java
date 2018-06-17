package com.graphics;

import java.awt.Color;

public class Oval {
	private int iX;
	private int iY;
	private int iWidth;
	private int iHeight;

	private int iCol1;
	private int iCol2;
	private int iCol3;
	private double dRotate;
	private boolean bDraw;

	public Oval(int iX, int iY, int iWidth, int iHeight, int iCol1, int iCol2, int iCol3) {
		this.iX = iX;
		this.iY = iY;
		this.iWidth = iWidth;
		this.iHeight = iHeight;
		this.iCol1 = iCol1;
		this.iCol2 = iCol2;
		this.iCol3 = iCol3;
		dRotate = 0;
		bDraw = true;
	}

	public Oval(int iX, int iY, int iWidth, int iHeight, Color col) {
		this.iX = iX;
		this.iY = iY;
		this.iWidth = iWidth;
		this.iHeight = iHeight;
		this.iCol1 = col.getRed();
		this.iCol2 = col.getGreen();
		this.iCol3 = col.getBlue();
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

	public int getiCol1() {
		return iCol1;
	}

	public void setiCol1(int iCol1) {
		this.iCol1 = iCol1;
	}

	public int getiCol2() {
		return iCol2;
	}

	public void setiCol2(int iCol2) {
		this.iCol2 = iCol2;
	}

	public int getiCol3() {
		return iCol3;
	}

	public void setiCol3(int iCol3) {
		this.iCol3 = iCol3;
	}

	public void mov(int iX, int iY) {
		this.iX += iX;
		this.iY += iY;
	}

	public double getdRotate() {
		return Math.toDegrees(dRotate);
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
