package com.tools;

public class Time {
	public static long lDelta = 0;
	public static long getTime() {
		return System.nanoTime();
	}
	public static float getDelta() {
		return (lDelta*60)/1000000000f;
	}
}
