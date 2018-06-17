package com.ai;

import java.io.BufferedWriter;
import java.util.ArrayList;
import com.tools.*;

public class Population {
	
	private ArrayList<Network> nPopulation = new ArrayList<Network>();
	private int iInputNum;
	private int iOutputNum; 

	public Population(int iPopulationSize, int iInputNum, int iOutputNum) {

		for (int i = 0; i < iPopulationSize; i++) {

			ArrayList<Integer> iStructure = new ArrayList<Integer>();
			iStructure.add(iInputNum);

			int iLayerNum = (int) (Math.random() * (iInputNum * 10)) + 1;

			for (int iZ = 0; iZ <= iLayerNum; iZ++) {
				iStructure.add((int) (Math.random() * (iInputNum * 10)) + iInputNum * 3);
			}
			
			iStructure.add(iOutputNum);

			nPopulation.add(new Network(iStructure));

			this.iInputNum = iInputNum;
			this.iOutputNum = iOutputNum;
		}
	}
	
	public Population (ArrayList<Integer> alNetStruct, int iInputsNum, int iOutputsNum, int iPopSize) {
		iInputNum = iInputsNum;
		iOutputNum = iOutputsNum;
		
		for (int i = 0; i <= iPopSize; i++) {
			nPopulation.add(new Network(alNetStruct));
		}
	}
	
	public void addRandomNetwork() {

		ArrayList<Integer> iStructure = new ArrayList<Integer>();
		iStructure.add(iInputNum);

		int iLayerNum = (int) (Math.random() * (iInputNum * 10)) + 1;

		for (int iZ = 0; iZ <= iLayerNum; iZ++) {
			iStructure.add((int) (Math.random() * (iInputNum * 450)) + iInputNum * 3);
		}
		
		iStructure.add(iOutputNum);

		nPopulation.add(new Network(iStructure));

	}
	
	public Boolean addNetwork(int iIndex, Network net) {
		
		if (net.getiStructure().get(0) == iInputNum &
				net.getiStructure().get(net.getiStructure().size()) == iOutputNum ) {
			
			nPopulation.add(iIndex, net);
			return true;
		}else {
			return false;
		}	
	}
	
	public Boolean setNetwork(int iIndex, Network net) {
		
		if (net.getiStructure().get(0) == iInputNum &
				net.getiStructure().get(net.getiStructure().size()) == iOutputNum ) {
			
			nPopulation.set(iIndex, net);
			return true;
		}else {
			return false;
		}	
	}
	
	public int copyNet(int iNeuralNet) {
		nPopulation.add(nPopulation.get(iNeuralNet));
		return nPopulation.size() - 1;
	}
	
	public void swapNet (int iNet1, int iNet2) {
		
		Network nNet1 = nPopulation.get(iNet1);
		Network nNet2 = nPopulation.get(iNet2);
		
		nPopulation.set(iNet1, nNet2);
		nPopulation.set(iNet2, nNet1);
	}
	
	public int size() {
		return nPopulation.size();
	}
	
	public void setFitness(int iNetworkNum, double dFitness) {
		nPopulation.get(iNetworkNum).setFitness(dFitness);
	}
	
	public double getFitness (int iNetworkNum) {
		double dfitness = nPopulation.get(iNetworkNum).getFitness();
		return dfitness;
	}
	
	public ArrayList<Double> getFitnessOfAll () {
		
		ArrayList<Double> dFitnessOfAll = new ArrayList<Double>();
		
		for (int i = 0; i < nPopulation.size(); i++) {
			dFitnessOfAll.add(nPopulation.get(i).getFitness());
		}
		
		return dFitnessOfAll;
	}
	
	public Boolean giveTask(ArrayList<Double> dInputs, int NetworkIndex) {
		if (dInputs.size() == iInputNum) {
			nPopulation.get(NetworkIndex).feedFoward(dInputs);
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean giveTaskToAll(ArrayList<Double> dInputs) {

		for (int i = 0; i < nPopulation.size(); i++) {
			if (dInputs.size() == iInputNum) {
				nPopulation.get(i).feedFoward(dInputs);
			} else {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Double> getResults(int iNetworkNum) {
		ArrayList<Double> dResults = new ArrayList<Double>();

		dResults = nPopulation.get(iNetworkNum).getdResults();

		return dResults;
	}
	
	public ArrayList<ArrayList<Double>> getAllResults() {
		ArrayList<ArrayList<Double>> dAllResults = new ArrayList<ArrayList<Double>>();

		for (int i = 0; i < nPopulation.size(); i++) {
			dAllResults.add(nPopulation.get(i).getdResults());
		}
		return dAllResults;
	}
	
	public int addMutated(int iNetworkNum, double dStrength) {
		int iNetworkNumCopy = copyNet(iNetworkNum);
		for (int i = 0; i < nPopulation.get(iNetworkNumCopy).lNetwork.size(); i++) {
			for (int iZ = 0; iZ < nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron
						.size(); iX++) {
					nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron
							.get(iX).dWeight += (Math.random() * (0.01 * dStrength)) - (0.005 * dStrength);
					if (nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight > 1.0) {
						nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight = 1.0;
					} else if (nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron
							.get(iX).dWeight < -1.0) {
						nPopulation.get(iNetworkNumCopy).lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight = -1.0;
					}
				}
			}
		}
		return iNetworkNumCopy;
	}
	
	public Network getMutated(int iNetworkNum, double dStrength) {
		Network nNetworkCopy = nPopulation.get(iNetworkNum);
		for (int i = 0; i < nPopulation.get(iNetworkNum).lNetwork.size(); i++) {
			for (int iZ = 0; iZ < nPopulation.get(iNetworkNum).lNetwork.get(i).nLayer.size(); iZ++) {
				for (int iX = 0; iX < nPopulation.get(iNetworkNum).lNetwork.get(i).nLayer.get(iZ).cNeuron
						.size(); iX++) {
					nNetworkCopy.lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight += (Math.random() * (0.01 * dStrength)) - (0.005 * dStrength);
					if (nNetworkCopy.lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight > 1.0) {
						nNetworkCopy.lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight = 1.0;
					} else if (nNetworkCopy.lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight < -1.0) {
						nNetworkCopy.lNetwork.get(i).nLayer.get(iZ).cNeuron.get(iX).dWeight = -1.0;
					}
				}
			}
		}
		return nNetworkCopy;
	}
	
	public void selection(float surviveRate) {

		int survivingNum = (int) (nPopulation.size() * surviveRate);
		System.out.println(survivingNum);
		while (nPopulation != null) {
		
			if (nPopulation.size() > survivingNum) {
				nPopulation.remove(ArrayListTools.indexOfMinD(getFitnessOfAll()));
			} else {
				break;
			}
		}
	}

	public void breed() {

	}
	
	public void evolve(int iNewPopulationSize) {

		selection(0.25f);
		
		for(int i = 0; i < nPopulation.size(); i++) {
			addMutated(i, 1);
		}
		
		while (nPopulation.size() <= iNewPopulationSize) {
			addRandomNetwork();
		}
		
	}

	public void save(String name) {

		BufferedWriter out;
		
	}

	public void loadPopulation() {

	}

}
