package com.ai;

import java.util.ArrayList;
import com.tools.*;

public class Network {

	static private int iLayerNum;
	protected ArrayList<Layer> lNetwork = new ArrayList<Layer>();
	private ArrayList<Double> dResults = new ArrayList<Double>();
	private int iFitness;
	private ArrayList<Integer> iStructure = new ArrayList<Integer>();

	public Network(ArrayList<Integer> iStructure) {
		
		this.iStructure = iStructure;
		
		int iNumOutputs;
		iLayerNum = iStructure.size();
		
		for(int i = 0; i < iLayerNum; i++) {	
			
			if(i == iStructure.size() - 1) {
				iNumOutputs = 0;
			}else {
				iNumOutputs = iStructure.get(i + 1);
			}
			
			lNetwork.add(new Layer(iStructure.get(i), iNumOutputs));	
		}
	}
	
	public Network(int iInputNum, int iOutputNum) {

		ArrayList<Integer> iStructure = new ArrayList<Integer>();
		iStructure.add(iInputNum);

		int iLayerNum = (int) (Math.random() * (iInputNum * 10)) + 1;

		for (int iZ = 0; iZ <= iLayerNum; iZ++) {
			iStructure.add((int) (Math.random() * (iInputNum * 450)) + iInputNum * 3);
		}
		
		iStructure.add(iOutputNum);
		
		this.iStructure = iStructure;
		
		int iNumOutputs;
		iLayerNum = iStructure.size();
		
		for(int i = 0; i < iLayerNum; i++) {	
			
			if(i == iStructure.size() - 1) {
				iNumOutputs = 0;
			}else {
				iNumOutputs = iStructure.get(i + 1);
			}
			
			lNetwork.add(new Layer(iStructure.get(i), iNumOutputs));	
		}

	}
	
	public ArrayList<Integer> getiStructure() {
		return iStructure;
	}

	public double[][][] getWeights(){
		
		double [][][] dWeights = 
				new double [lNetwork.size()][ArrayListTools.maxI(iStructure)][ArrayListTools.maxI(iStructure)];
		
		for (int i = 0; i < lNetwork.size(); i++) {
			for (int iZ = 0; iZ < lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < lNetwork.get(i).nLayer.get(iZ).cNeuron.size(); iX++) {
					dWeights [i][iZ][iX] = lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight;				}
			}
		}
		
		return dWeights;
		
	}
	
	public Integer getFitness() {
		return iFitness;
	}

	public void setFitness(int iFitness) {
		this.iFitness = iFitness;
	}

	public ArrayList<Double> getdResults() {
		return dResults;
	}
	
	public int size() {
		return lNetwork.size();
	}
	
	public int layerSize(int index) {
		return lNetwork.get(index).nLayer.size();
	}

	public boolean feedFoward(ArrayList<Double> dInput) {
		
		if(dInput.size() == lNetwork.get(0).nLayer.size() - 1) {
			lNetwork.get(0).giveInput(dInput);
			
			for (int i = 1; i < lNetwork.size(); i++) {
				Layer prevLayer = lNetwork.get(i - 1);
				lNetwork.get(i).feedFoward(prevLayer);
			}
			
			dResults.clear();
			
			for (int i = 0; i < lNetwork.get(lNetwork.size()-1).nLayer.size()-1; i++) {
				dResults.add(lNetwork.get(lNetwork.size()-1).nLayer.get(i).getdOutput());
			}
			
			return true;
		} else {
			return false;
		}
	}

}
