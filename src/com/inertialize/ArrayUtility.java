package com.inertialize;
import java.util.Random;

public class ArrayUtility {
	private static Random r = new Random();

	private static int randomRange(int min, int max) { // min & max are inclusive
		if (max - min <= 0) return min;
		return min + r.nextInt(1 + max - min);
	}
	
	public static void swapElements(int[] a, int i1, int i2) {
		final int temp = a[i1];
		a[i1] = a[i2];
		a[i2] = temp;
	}
	
	public static void print(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			if (i > 0) sb.append(",");
			sb.append(a[i]);
		}
		System.out.println(sb.toString());
	}
	
	public static void fill(int[] a) {
		for (int i = 0; i < a.length; i++)
			a[i] = i;
	}
	
	public static void reverse(int[] a) {
		int i = 0, j = a.length - 1;
		while (i < j)
			swapElements(a, i++, j--);
	}
	
	public static void fillRandom(int[] a, int min, int max) {
		for (int i = 0; i < a.length; i++) {
			a[i] = randomRange(min, max);
		}
	}
	
	public static void shuffle(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int rnd = randomRange(0, a.length - 1);
			swapElements(a, i, rnd);
		}
	}
	
	public static void printIsSorted(int[] a) {
		System.out.println(isSorted(a) ? "Array is Sorted" : "Array is Not Sorted");
	}
	
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) return false;
		}
		return true;
	}
}
