package com.training;

import java.util.ArrayList;

import com.ai.Population;
import com.game.Bird;
import com.game.EngineFlappyBird;
import com.game.MainGame;

public class TrainingController extends Thread {

	Population pop;
	boolean bRunTraining;
	
	public TrainingController(int iPopulationSize, int iInputNum, int iOutputNum) {
		
		pop = new Population(iPopulationSize, iInputNum, iOutputNum);
		bRunTraining = true;
		
	}
	
	public void run() {
		
		com.game.MainGame.eng.startGame(pop.size());
		
		while (bRunTraining) {
			for (int i = 0; i <= (pop.size()-1) ; i++) {
				
				ArrayList<Double> dInput = new ArrayList<Double>();
				//dInput.add(MainGame.eng.birds.get(i).);
				//dInput.add(MainGame.eng.birds.get(i).);
				//dInput.add(MainGame.eng.birds.get(i).);
				
				pop.giveTask(dInput, i);
				
				if(!MainGame.eng.birds.get(i).isAlive()) {
					pop.setFitness(i, MainGame.eng.birds.get(i).getiPunkte());
				}
				else if (pop.getResults(i).get(0) > 0.5) {
					
					MainGame.eng.birds.get(i).flap();
					
				}
			}
			int temp = 0;
			
			for (Bird birds : MainGame.eng.birds) {
				if (birds.isAlive()) {
					temp ++;
				}
			}
			
			if (temp == 10) {
				pop.evolve();
			}
			
		}
	}
}
