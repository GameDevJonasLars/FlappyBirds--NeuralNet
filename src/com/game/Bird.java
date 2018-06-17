package com.game;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Engine;
import com.engine.Window;
import com.graphics.Rechteck;
import com.tools.ResourceLoader;
import com.tools.Time;

public class Bird {
	private Window window;
	private int iBody;
	private int iBoden;
	private float fMov;
	private double dAdd;
	private double d�ber;
	private float fWinkel;
	private int iTimeout;
	private int iTimeFl�gel;
	private boolean bFl�gel;
	private boolean bAlive;
	private int iIndex;
	private int iAbstandBoden;
	private int iAbstandR�hreHorizontal;
	private int iAbstandR�hreVertikal;
	private int iPunkte;
	private int iPunkteR�hre;

	public Bird(Window window, int iIndex) {
		this.window = window;
		fMov = 0;
		dAdd = 0;
		d�ber = 0;
		fWinkel = 0;
		iTimeout = 40;
		iTimeFl�gel = 15;
		bFl�gel = true;
		this.iIndex = iIndex;
		bAlive = true;
		iAbstandBoden = 0;
		iAbstandR�hreHorizontal = 0;
		iAbstandR�hreVertikal = 0;
	}

	public void update() {

		if (Time.getDelta() < 1 || Time.getDelta() == 1) {
			if (bAlive) {
				dAdd += Time.getDelta();
				if (dAdd > 1) {
					iTimeout--;
					iTimeFl�gel--;
					fMov += 0.5f;
					window.getSprites().get(iBody).mov(0, (int) (fMov));
					dAdd--;
					if (fMov > 0 && fWinkel < 90 && iTimeout < 0) {
						fWinkel += 4f;
						window.getSprites().get(iBody).setdRotate((int) fWinkel);
					} else if (fMov < 0 && fWinkel > -10) {

						fWinkel -= 5;
						window.getSprites().get(iBody).setdRotate((int) (fWinkel));
					}
					if (iTimeFl�gel < 0) {
						if (bFl�gel) {
							try {
								window.getSprites().get(iBody)
										.setImg(ImageIO.read(ResourceLoader.load("FlappyBirdOben.PNG")));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							try {
								window.getSprites().get(iBody)
										.setImg(ImageIO.read(ResourceLoader.load("FlappyBirdUnten.PNG")));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						bFl�gel = !bFl�gel;
						iTimeFl�gel = 15;
					}
					iPunkte = Punkte.getiPunkte();
					iPunkteR�hre = Punkte.getiPunkteR�hre();
					iAbstandBoden = window.getSprites().get(iBoden).getiY() - window.getSprites().get(iBody).getiY()
							- window.getSprites().get(iBody).getiHeight();
					iAbstandR�hreHorizontal = window.getSprites()
							.get(RohrController.rohre.get(iPunkteR�hre).getiR�hreOben()).getiX()
							- window.getSprites().get(iBody).getiX() - window.getSprites().get(iBody).getiWidth();
					iAbstandR�hreVertikal = (window.getSprites()
							.get(RohrController.rohre.get(iPunkteR�hre).getiR�hreUnten()).getiY() - 100)
							- (window.getSprites().get(iBody).getiY()
									+ window.getSprites().get(iBody).getiHeight() / 2);
				}

			} else {
				window.getSprites().get(iBody).mov(-3, 0);
			}
		}
		if (Time.getDelta() > 1) {
			if (bAlive) {
				d�ber += Time.getDelta();
				for (int i = 0; d�ber > 1; i++) {
					iTimeout--;
					iTimeFl�gel--;
					fMov += 0.5f;
					window.getSprites().get(iBody).mov(0, (int) (fMov));
					d�ber--;
					if (fMov > 0 && fWinkel < 90 && iTimeout < 0) {
						fWinkel += 4f;
						window.getSprites().get(iBody).setdRotate((int) fWinkel);
					} else if (fMov < 0 && fWinkel > -10) {

						fWinkel -= 5;
						window.getSprites().get(iBody).setdRotate((int) (fWinkel));
					}
					if (iTimeFl�gel < 0) {
						if (bFl�gel) {
							try {
								window.getSprites().get(iBody)
										.setImg(ImageIO.read(ResourceLoader.load("FlappyBirdOben.PNG")));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							try {
								window.getSprites().get(iBody)
										.setImg(ImageIO.read(ResourceLoader.load("FlappyBirdUnten.PNG")));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						bFl�gel = !bFl�gel;
						iTimeFl�gel = 15;
					}
					iPunkte = Punkte.getiPunkte();
					iPunkteR�hre = Punkte.getiPunkteR�hre();
					iAbstandBoden = window.getSprites().get(iBoden).getiY() - window.getSprites().get(iBody).getiY()
							- window.getSprites().get(iBody).getiHeight();
					iAbstandR�hreHorizontal = window.getSprites()
							.get(RohrController.rohre.get(iPunkteR�hre).getiR�hreOben()).getiX()
							- window.getSprites().get(iBody).getiX() - window.getSprites().get(iBody).getiWidth();
					iAbstandR�hreVertikal = (window.getSprites()
							.get(RohrController.rohre.get(iPunkteR�hre).getiR�hreUnten()).getiY() - 100)
							- (window.getSprites().get(iBody).getiY()
									+ window.getSprites().get(iBody).getiHeight() / 2);

				}
			} else {
				window.getSprites().get(iBody).mov(-3, 0);
			}
		}

		Punkte.addPunkte(1);
	}

	public void render() {

	}

	public void getNames() {
		for (Objekte objekte : ObjektListe.lObjekte) {
			if ("Boden".equals(objekte.getsName())) {
				iBoden = objekte.getiIndex();
			}
		}
	}

	public void collision() {
		if (new Rectangle(window.getSprites().get(iBody).getiX(), window.getSprites().get(iBody).getiY(),
				window.getSprites().get(iBody).getiWidth(), window.getSprites().get(iBody).getiHeight())
						.intersects(new Rectangle(window.getSprites().get(iBoden).getiX(),
								window.getSprites().get(iBoden).getiY(), window.getSprites().get(iBoden).getiWidth(),
								window.getSprites().get(iBoden).getiHeight()))) {
			bAlive = false;
			fMov = 0;

		}
		for (RohrBlockade block : RohrController.rohre) {

			if (new Rectangle(window.getSprites().get(iBody).getiX(), window.getSprites().get(iBody).getiY(),
					window.getSprites().get(iBody).getiWidth(), window.getSprites().get(iBody).getiHeight())
							.intersects(new Rectangle(window.getSprites().get(block.getiR�hreOben()).getiX(),
									window.getSprites().get(block.getiR�hreOben()).getiY(),
									window.getSprites().get(block.getiR�hreOben()).getiWidth(),
									window.getSprites().get(block.getiR�hreOben()).getiHeight()))) {
				bAlive = false;
				fMov = 0;

			}
			if (new Rectangle(window.getSprites().get(iBody).getiX(), window.getSprites().get(iBody).getiY(),
					window.getSprites().get(iBody).getiWidth(), window.getSprites().get(iBody).getiHeight())
							.intersects(new Rectangle(window.getSprites().get(block.getiR�hreUnten()).getiX(),
									window.getSprites().get(block.getiR�hreUnten()).getiY(),
									window.getSprites().get(block.getiR�hreUnten()).getiWidth(),
									window.getSprites().get(block.getiR�hreUnten()).getiHeight()))) {
				bAlive = false;
				fMov = 0;

			}
		}
	}

	public void init() {
		try {
			iBody = window.addSprite(300, MainGame.HEIGHT/2-200, ImageIO.read(ResourceLoader.load("FlappyBirdUnten.PNG")),
					"Body" + iIndex);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void flap() {
		fMov = -10f;
		iTimeout = 40;
	}

	public int getiIndex() {
		return iIndex;
	}

	public boolean isbAlive() {
		return bAlive;
	}

	public void setbAlive(boolean bAlive) {
		this.bAlive = bAlive;
	}

	public float getfWinkel() {
		return fWinkel;
	}

	public void setfWinkel(float fWinkel) {
		this.fWinkel = fWinkel;
	}
	
	public int getiAbstandBoden() {
		return iAbstandBoden;
	}

	public int getiAbstandR�hreHorizontal() {
		return iAbstandR�hreHorizontal;
	}

	public int getiAbstandR�hreVertikal() {
		return iAbstandR�hreVertikal;
	}

	public int getiPunkte() {
		return iPunkte;
	}

}
