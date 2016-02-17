package com.inertialize;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public abstract class Sortable {
	private static Random r = new Random();
	protected int[] a;

	private static int randomRange(int min, int max) { // min & max are inclusive
		if (max - min <= 0) return min;
		return min + r.nextInt(1 + max - min);
	}
	
	public void copy(int[] a) {
		this.a = Arrays.copyOf(a, a.length);
	}
	
	public abstract void sort();
	
	protected void swap(int i1, int i2) {
		final int temp = a[i1];
		a[i1] = a[i2];
		a[i2] = temp;
	}
	
	protected void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			if (i > 0) sb.append(",");
			sb.append(a[i]);
		}
		System.out.println(sb.toString());
	}
	
	protected void fill() {
		for (int i = 0; i < a.length; i++)
			a[i] = i;
	}
	
	protected void reverse() {
		int i = 0, j = a.length - 1;
		while (i < j)
			swap(i++, j--);
	}
	
	protected void fillRandom(int min, int max) {
		for (int i = 0; i < a.length; i++) {
			a[i] = randomRange(min, max);
		}
	}
	
	protected void shuffle() {
		for (int i = 0; i < a.length; i++) {
			int rnd = randomRange(0, a.length - 1);
			swap(i, rnd);
		}
	}
	
	protected boolean isSorted() {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) return false;
		}
		return true;
	}
	
	protected boolean matchSorted(int[] sortedTestArray) {
		// Run this test after sorting a[]
		if (a.length != sortedTestArray.length) return false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != sortedTestArray[i]) return false;
		}
		return true;
	}
	
	public void printIsSorted() {
		System.out.println(isSorted() ? "Array is Sorted" : "Array is Not Sorted");
	}
	
	public void test(int[] sortedTestArray) {
		long time = System.nanoTime();
		this.sort();
		double elapsedMs = (double)((System.nanoTime() - time) / 1000000.0);

		System.out.println(
				"Sorting Algorithm: " + String.format("%-20s", this.getClass().getSimpleName())
				+ "\t Num. Elements: " + a.length 
				+ "\t Sorted: " + (isSorted() ? "Yes" : "No")
				+ "\t Match Sorted Array: " + (matchSorted(sortedTestArray) ? "Yes" : "No")
				+ "\t Elapsed Time: " + (new DecimalFormat("0.00##").format(elapsedMs)) + " ms");
	}
}
