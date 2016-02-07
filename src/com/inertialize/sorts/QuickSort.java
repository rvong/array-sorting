package com.inertialize.sorts;

import com.inertialize.Sortable;

public class QuickSort extends Sortable {

	@Override
	public void sort() {
		quickSort(0, a.length - 1);
	}
	
	private void quickSort(int lo, int hi) {
		int i = lo, j = hi;
		int pivot = a[(int) Math.floor((lo + hi) / 2)];
		while (i <= j) {
			if (a[i] < pivot) { i++; continue; }
			if (a[j] > pivot) { j--; continue; }
			if (i <= j) swap(i++, j--);
		}
		if (lo < j) quickSort(lo, j);
		if (i < hi) quickSort(i, hi);
	}
}
