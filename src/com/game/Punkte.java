package com.game;

import com.tools.Time;

public class Punkte {
	private static int iPunkte;
	private static int iHighscore;
	private static float dAdd = 0;
	public static int getiPunkte() {
		return iPunkte;
	}
	public static void setiPunkte(int iPunkte) {
		Punkte.iPunkte =  iPunkte;
	}
	public static void addPunkte(int iPunkte) {
		
		dAdd += iPunkte * Time.getDelta();
		if (dAdd > 1) {
			Punkte.iPunkte += (int)dAdd;
			dAdd -=(int)dAdd;
		}
	}
	public static int getiHighscore() {
		return iHighscore;
	}
	public static void setiHighscore(int iHighscore) {
		Punkte.iHighscore = iHighscore;
	}
	
}
