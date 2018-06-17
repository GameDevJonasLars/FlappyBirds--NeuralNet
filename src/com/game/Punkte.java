package com.game;

import com.tools.Time;

public class Punkte {
	private static int iPunkte = 0;
	private static int iHighscore = 0;
	private static int iPunkteRöhre = 0;
	private static int iHighscoreRöhre = 0;
	private static float dAdd = 0;

	public static int getiPunkte() {
		return iPunkte;
	}

	public static void setiPunkte(int iPunkte) {
		Punkte.iPunkte = iPunkte;
	}

	public static void addPunkte(int iPunkte) {

		dAdd += iPunkte * Time.getDelta();
		if (dAdd > 1) {
			Punkte.iPunkte += (int) dAdd;
			dAdd -= (int) dAdd;
		}
	}

	public static int getiHighscore() {
		return iHighscore;
	}

	public static void setiHighscore(int iHighscore) {
		Punkte.iHighscore = iHighscore;
	}

	public static int getiPunkteRöhre() {
		return iPunkteRöhre;
	}

	public static void setiPunkteRöhre(int iPunkteRöhre) {
		Punkte.iPunkteRöhre = iPunkteRöhre;
	}

	public static int getiHighscoreRöhre() {
		return iHighscoreRöhre;
	}

	public static void setiHighscoreRöhre(int iHighscoreRöhre) {
		Punkte.iHighscoreRöhre = iHighscoreRöhre;
	}

}
