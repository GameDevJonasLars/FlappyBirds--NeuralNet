package com.tools;

import java.util.ArrayList;

public class ArrayListTools {

	public static int maxI (ArrayList<Integer> iList) {
		int max = iList.get(0);
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) > max) {
				max = iList.get(i);
			}
		}
		return max;	
	}
	
	public static double maxD (ArrayList<Double> dList) {
		Double max = dList.get(0);
		
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i) > max) {
				max = dList.get(i);
			}
		}
		return max;	
	}
	
	public static void removeMaxI (ArrayList<Integer> iList) {
		int max = 0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) > iList.get(max)) {
				max = i;
			}
		}
		
		iList.remove(max);
	}
	
	public static void removeMaxD (ArrayList<Double> dList) {
		int max = 0;
		
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i) > dList.get(max)) {
				max = i;
			}
		}
		
		dList.remove(max);
	}
	
	public static int indexOfMaxI (ArrayList<Integer> iList) {
		int max = 0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) > iList.get(max)) {
				max = i;
			}
		}
		
		iList.remove(max);
		
		return max;	
	}
	
	public static int indexOfMaxD (ArrayList<Double> dList) {
		int max = 0;
		
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i) > dList.get(max)) {
				max = i;
			}
		}
		
		dList.remove(max);
		
		return max;	
	}
	
	public static int minI (ArrayList<Integer> iList) {
		int min = iList.get(0);
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) < min) {
				min = iList.get(i);
			}
		}
		return min;	
	}
	
	public static Double minD (ArrayList<Double> dList) {
		Double min = dList.get(0);
		
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i) < min) {
				min = dList.get(i);
			}
		}
		return min;	
	}
	
	public static void removeMinI (ArrayList<Integer> iList) {
		int min = 0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) < iList.get(min)) {
				min = i;
			}
		}
		
		iList.remove(min);
	}
	
	public static void removeMinD (ArrayList<Double> dList) {
		int min = 0;
		
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i) > dList.get(min)) {
				min = i;
			}
		}
		
		dList.remove(min);
	}
	
	public static int indexOfMinI (ArrayList<Integer> iList) {
		int min = 0;
		
		for (int i = 0; i < iList.size(); i++) {
			if (iList.get(i) < iList.get(min)) {
				min = i;
			}
		}
		
		iList.remove(min);
		
		return min;
	}
	
	public static int indexOfMinD (ArrayList<Double> dList) {
		int min = 0;
		
		for (int i = 0; i < dList.size(); i++) {
			if (dList.get(i) > dList.get(min)) {
				min = i;
			}
		}
		
		dList.remove(min);
		
		return min;
	}

}
