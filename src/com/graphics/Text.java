package com.graphics;

import java.awt.Font;

public class Text {
	private String sText;
	private int iX;
	private int iY;
	private int iScale;
	private Font foFont;

	public Text(String sText, int iX, int iY, int iScale) {
		this.sText = sText;
		this.iX = iX;
		this.iY = iY;
		foFont = new Font("SansSerif", Font.PLAIN, iScale);
	}

	public Text(String sText, int iX, int iY) {
		this.sText = sText;
		this.iX = iX;
		this.iY = iY;
		foFont = new Font("SansSerif", Font.PLAIN, 36);
	}

	public Text(String sText, int iX, int iY, Font foFont) {
		this.sText = sText;
		this.iX = iX;
		this.iY = iY;
		this.foFont = foFont;
	}

	public String getsText() {
		return sText;
	}

	public void setsText(String sText) {
		this.sText = sText;
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

	public Font getFoFont() {
		return foFont;
	}

	public void setFoFont(Font foFont) {
		this.foFont = foFont;
	}

}
