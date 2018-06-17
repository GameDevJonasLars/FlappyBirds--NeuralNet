package com.training;

import java.util.ArrayList;

import com.ai.Population;
import com.game.Bird;
import com.game.MainGame;

public class TrainingController extends Thread {

	private Population pop;
	private boolean bRunTraining;
	private int iGeneration = 1;

	public TrainingController(int iPopulationSize, int iInputNum, int iOutputNum) {
		
		pop = new Population(iPopulationSize, iInputNum, iOutputNum);
		
	}
	
	public int getiGeneration() {
		return iGeneration;
	}

	public void stopTraining() {
		this.bRunTraining = false;
	}
	
	public void run() {
		
		com.game.MainGame.eng.startGame(pop.size());
		
		while (bRunTraining) {
			
			while(true) {
				
				for (int i = 0; i <= (pop.size()-1) ; i++) {
					
					ArrayList<Double> dInput = new ArrayList<Double>();
					dInput.add((double) MainGame.eng.birds.get(i).getiAbstandBoden());
					dInput.add((double) MainGame.eng.birds.get(i).getiAbstandRöhreHorizontal());
					dInput.add((double) MainGame.eng.birds.get(i).getiAbstandRöhreVertikal());
					
					pop.giveTask(dInput, i);
					
					if(!MainGame.eng.birds.get(i).isbAlive()) {
						pop.setFitness(i, MainGame.eng.birds.get(i).getiPunkte());
					}
					else if (pop.getResults(i).get(0) > 0.5) {
						
						MainGame.eng.birds.get(i).flap();
						
					}
				}
				
				int temp = 0;
				
				for (Bird birds : MainGame.eng.birds) {
					if (birds.isbAlive()) {
						temp ++;
					}
				}
				
				if (temp == 10) {
					pop.evolve(10);
					iGeneration ++;
					break;
				}
		
			}
			
			MainGame.eng.restartGame();
			
		}
	}
}
