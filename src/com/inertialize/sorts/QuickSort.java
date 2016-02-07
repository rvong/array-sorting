package com.inertialize.sorts;

import com.inertialize.Sortable;

// Best case O(n log n).
// Worst case O(n^2) with a consistent bad chosen pivot.
// This implementation chooses the middle as the pivot so it's actually
// pretty good if the array is already sorted.
// The ideal pivot is the median value in the collection. Such that partitions are evenly sized.
// In the conventional implementation, the first element is chosen as the pivot.
// In sorted (ascending or descending) collections, the first or last element is an outlier
// which results in partitions of unbalanced, asymmetrically sized partitions.
// QuickSort works by:
// Splitting collection into partitions. Continuously halving partitions.
// Base case: i, j indexes.
// i and j start at 0 and end.
// swaps until i, j markers meet.
// then you have 2 partitions with all elements smaller/larger than pivot in different partitions.
// Repeat partitioning/swapping for small partitions until partitions of size 
// Stop recursing when lo >= j, which means the partition size is 1. lo is beginning of parition, j is high index.
// lo is 1st element of partition, hi is last element of partition
// i is low index, j is high index.
// when i and j cross, stop the partitioning/swapping done for that partition.
// repeat for smaller partitions. The condition to continue partitioning
// is if low limit < high index, meaning the partition size is > 1
// and also if low index < high limit, meaning the partition size is > 1.
// high index moves left, low index moves right.
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
