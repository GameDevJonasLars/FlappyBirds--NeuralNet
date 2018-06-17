package com.game;

import com.tools.Time;

public class Punkte {
	private static int iPunkte = 0;
	private static int iHighscore = 0;
	private static int iPunkteR�hre = 0;
	private static int iHighscoreR�hre = 0;
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

	public static int getiPunkteR�hre() {
		return iPunkteR�hre;
	}

	public static void setiPunkteR�hre(int iPunkteR�hre) {
		Punkte.iPunkteR�hre = iPunkteR�hre;
	}

	public static int getiHighscoreR�hre() {
		return iHighscoreR�hre;
	}

	public static void setiHighscoreR�hre(int iHighscoreR�hre) {
		Punkte.iHighscoreR�hre = iHighscoreR�hre;
	}

}
