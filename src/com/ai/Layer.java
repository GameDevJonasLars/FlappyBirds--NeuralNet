package com.ai;

import java.util.ArrayList;

public class Layer {

	protected ArrayList<Neuron> nLayer = new ArrayList<Neuron>();;
	
	public Layer(int iNeuronNum, int iNumOutputs) {
		
		for(int i = 0; i <= iNeuronNum; i++) {		
			nLayer.add(new Neuron(i, iNumOutputs));
		}
		nLayer.get(nLayer.size()-1).setdOutput(1.0);
	}
	
	public void giveInput(ArrayList<Double> dInput) {
		
		for(int i = 0; i < nLayer.size() - 1; i++) {
			nLayer.get(i).setdOutput(dInput.get(i));
		}
	}
	
	public void feedFoward(Layer prevLayer) {
		for(int i = 0; i < nLayer.size() - 1; i++) {
			nLayer.get(i).feedForward(prevLayer);
		}
	}

}
