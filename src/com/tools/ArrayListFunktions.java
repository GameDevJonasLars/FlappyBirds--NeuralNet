package com.tools;

import java.util.ArrayList;

public class ArrayListFunktions {

	public static int maxI (ArrayList<Integer> iList) {
		int max = 0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) > max) {
				max = iList.get(i);
			}
		}
		return max;	
	}
	
	public static double maxD (ArrayList<Double> iList) {
		double max = 0.0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) > max) {
				max = iList.get(i);
			}
		}
		return max;	
	}
	
	public static ArrayList<Double> removeMaxD (ArrayList<Double> iList) {
		double max = 0.0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) > max) {
				max = i;
			}
		}
		
		iList.remove(max);
		
		return iList;	
	}
	

}
