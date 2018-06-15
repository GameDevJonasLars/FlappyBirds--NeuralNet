package com.ai;

import java.util.ArrayList;

public class Neuron {
	
	private int iIndex;
	private double dOutput;

	protected ArrayList<Connection> cNeuron = new ArrayList<Connection>();
	
	public Neuron(int iIndex, int iOutputs) {
		this.iIndex = iIndex;
		
		for(int i = 0; i < iOutputs; i++) {
			cNeuron.add(new Connection());
		}
	}
	
	public int getiIndex() {
		return iIndex;
	}

	public void setiIndex(int iIndex) {
		this.iIndex = iIndex;
	}

	public double getdOutput() {
		return dOutput;
	}

	public void setdOutput(double dOutput) {
		this.dOutput = dOutput;
	}

	public double trnasferFunction(double dInput) {
		return Math.tanh(dInput);
	}
	
	public double transferFunctionDerivative(double dInput) {
		return 1.0 - dInput * dInput;
	}
	
	public void feedForward(Layer prevLayer) {
		
		double dSum = 0;
		
		for(int i = 0; i < prevLayer.nLayer.size(); i++) {
			dSum += prevLayer.nLayer.get(i).getdOutput() 
					* prevLayer.nLayer.get(i).cNeuron.get(iIndex).dWeight;
		}
		
		dOutput = trnasferFunction(dSum);
		
	}

}
