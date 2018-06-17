package com.training;

import com.ai.Population;
import com.game.EngineFlappyBird;

public class TrainingController extends Thread {

	Population pop;
	
	public TrainingController(int iPopulationSize, int iInputNum, int iOutputNum) {
		
		pop = new Population(iPopulationSize, iInputNum, iOutputNum);
		
	}
	
	public void run() {
		
		com.game.MainGame.eng.start();
		
	}

}
