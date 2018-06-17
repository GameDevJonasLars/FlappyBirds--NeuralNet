package com.training;

import java.util.ArrayList;

import com.ai.Population;
import com.engine.Window;
import com.game.Bird;
import com.game.EngineFlappyBird;
import com.game.MainGame;

public class TrainingController extends Thread {

	private Population pop;
	private boolean bRunTraining;
	private int iGeneration = 1;
	Window window;
	EngineFlappyBird eng;

	public TrainingController(Window window, int iPopulationSize, int iInputNum, int iOutputNum) {
		this.window = window;
		eng = new EngineFlappyBird(window);
		pop = new Population(iPopulationSize, iInputNum, iOutputNum);
		bRunTraining = true;

	}

	public int getiGeneration() {
		return iGeneration;
	}

	public void stopTraining() {
		this.bRunTraining = false;
	}

	public void run() {

		eng.startGame(pop.size());

		while (bRunTraining) {
			eng.setbUpdate(true);

			while (true) {

			boolean bRoundRunning = true;
			



				for (int i = 0; i < (pop.size()); i++) {

					ArrayList<Double> dInput = new ArrayList<Double>();
					// dInput.add((double) eng.birds.get(i).getiAbstandBoden());
					dInput.add((double) eng.birds.get(i).getiAbstandRöhreHorizontal());
					dInput.add((double) eng.birds.get(i).getiAbstandRöhreVertikal());

					pop.giveTask(dInput, i);

					if (!eng.birds.get(i).isbAlive()) {

						pop.setFitness(i, eng.birds.get(i).getiPunkte() - eng.birds.get(i).getiAbstandRöhreVertikal());

					} else if (pop.getResults(i).get(0) > 0.5f) {

						eng.birds.get(i).flap();
					}
				}

				int temp = 0;

				for (Bird birds : eng.birds) {
					if (!birds.isbAlive()) {
						temp++;
					}
				}

				if (temp == eng.birds.size()) {

				

				if (temp == pop.size()) {
					eng.setbUpdate(false);
					pop.evolve(eng.birds.size());
					iGeneration++;
					bRoundRunning = false;
					break;
				}

			}
			}
			eng.restartGame();
			

		}
	}
}
