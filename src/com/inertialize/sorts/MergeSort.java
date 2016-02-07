package com.inertialize.sorts;

import java.text.DecimalFormat;
import java.util.Arrays;

import com.inertialize.Sortable;

public class MergeSort extends Sortable {

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		System.out.println("Call int[] mergeSort(int[] a)");
	}
	
	public int[] mergeSort(int[] a) {
		if (a.length <= 1) return a;
		int mid = a.length / 2;
		int[] m1 = mergeSort(Arrays.copyOfRange(a, 0, mid));
		int[] m2 = mergeSort(Arrays.copyOfRange(a, mid, a.length));
		return merge(m1, m2);
	}
	
	public static int[] merge(int a[], int[] b) {
		int[] merged = new int[a.length + b.length];
		int i = 0, j = 0, n = 0;		
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j])
				merged[n++] = a[i++];
			else
				merged[n++] = b[j++];
		}
		while (i < a.length) merged[n++] = a[i++];
		while (j < b.length) merged[n++] = b[j++];
		return merged;
	}

	@Override
	public void test() {
		long time = System.nanoTime();
		a = this.mergeSort(a);
		double elapsedMs = (double)((System.nanoTime() - time) / 1000000.0);
		
		System.out.println("Sorting Algorithm: " + String.format("%-20s", this.getClass().getSimpleName())
				+ "\t Num. Elements: " + a.length 
				+ "\t Sorted: " + (isSorted() ? "Yes" : "No")
				+ "\t Elapsed Time: " + (new DecimalFormat("0.00##").format(elapsedMs)) + " ms");
	}
}
