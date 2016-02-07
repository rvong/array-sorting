package com.inertialize.sorts;

import com.inertialize.Sortable;

// Simple modification of QuickSort.
// Utilize Insertion sort for partitions of size n <= 10.
// Insertion sort has constant factor. Faster for very small collections.
public class InsertionQuickSort extends Sortable {

	@Override
	public void sort() {
		insQuickSort(0, a.length - 1);
	}
	
	private void insQuickSort(int lo, int hi) {
		if ((hi - lo) <= 10) { insertionSort(lo, hi); return;}
		int i = lo, j = hi;
		int pivot = a[(int) Math.floor((lo + hi) / 2)];
		while (i <= j) {
			if (a[i] < pivot) { i++; continue; }
			if (a[j] > pivot) { j--; continue; }
			if (i <= j) swap(i++, j--);
		}
		if (lo < j) insQuickSort(lo, j);
		if (i < hi) insQuickSort(i, hi);
	}
	
	private void insertionSort( int lo, int hi) {
		for (int i = lo + 1; i < hi + 1; i++) {
			int j, temp = a[i];		// Instead of swapping, save value to be placed in order into temp
			// Move all values greater than a[i] (temp) upward
			for (j = i; j > 0 && temp < a[j - 1]; j--)
				a[j] = a[j - 1];	// Move greater values up 
			a[j] = temp;
		}
	}
}
