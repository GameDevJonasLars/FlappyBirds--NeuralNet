package com.training;

import com.ai.Population;

public abstract class TrainingController extends Thread {

	
	
	public TrainingController(int iPopulationSize, int iInputNum, int iOutputNum) {
		
		Population pop = new Population(iPopulationSize, iInputNum, iOutputNum);
		
	}
	
	abstract public void run();

}
