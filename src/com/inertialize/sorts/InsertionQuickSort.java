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
		if ((hi - lo) <= 10) { insertionSort(lo, hi); return; }
		int pivot = a[(lo + hi)/2];
		int i = lo, j = hi;
		while (i <= j) {
			while ( a[i] < pivot) i++; 
			while (a[j] > pivot) j--;
			if (i <= j) swap(i++, j--);
		}
		insQuickSort(lo, j);
		insQuickSort(i, hi);
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
