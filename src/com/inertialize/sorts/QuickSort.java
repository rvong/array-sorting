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
// is if low limit < high index, meaning the partition size is >= 1
// and also if low index < high limit, meaning the partition size is >= 1.
// high index moves left, low index moves right.
public class QuickSort extends Sortable {

	@Override
	public void sort() {
		quickSort(0, a.length - 1);
	}
	
	private void quickSort(int lo, int hi) {
		if (lo >= hi) return; 			// if lo >= hi, done with swapping partition (size == 1 means already sorted) or bad input
		int i = lo, j = hi;				// indexes to swap
		int pivot = a[(lo+hi)/2];		// make pivot be the middle element
		while (i <= j) {				// don't cross partition
			while (a[i] < pivot) i++;	// i and j won't cross here because pivot is the middle element
			while (a[j] > pivot) j--;	// if == pivot then it stops incrementing/decrementing
			if (i <= j) swap(i++, j--);	// swap and increment, increment again, if i == j, still need to move because partitions can't include same element (the pivot).
		}
		quickSort(lo, j);	// recurse low partition (i and j have crossed such that j < i)
		quickSort(i, hi);	// recurse high partition
	}
	
	
	/**
	 i increments until it finds element >= pivot, j decrements until elements <= pivot
	 so if i == j, then i and j point to same value, with value same as pivot value.
	 if i == j == 8, i++, j-- => i = 9, j = 7 and pivot = 8 (in correct position)
	 if i == 7, j==8, => swap, i++, j-- then i = 8, j = 7, then sort(lo, j), sort (i, hi).
	 
	 */
}
