package com.inertialize;
import java.util.Arrays;

public class ArraySorter {
	// Bubble sort swaps element i with subsequent element i+1 if i > i+1 until the array is sorted.
	// The largest element "bubbles" to the end of the array. Reduce search limit k by 1 each iteration since
	// it's known that the highest element is in the correct position after each iteration.
	// Worst case is O(n^2). Best case is O(n) by exiting the subroutine if no swaps are made.
	public static void bubbleSort(int[] a) {
		boolean done = false;
		for (int k = 1; k < a.length && !done; k++) {
			done = true; 	// set true in case no swaps made, exit subroutine
			for (int i = 0; i < a.length - k; i++) {
				if (a[i] > a[i + 1]) {
					ArrayUtility.swapElements(a, i, i + 1);
					done = false;	// continue since swap was made
				}
			}
		}
	}
	
	// bubble sort in both directions. (bubble to end. bubble to beginning)
	// solves Turtle and Rabbit problem.
	public static void shakerSort(int[] a) {
		boolean done = false;
		for (int k = 1; k < a.length && !done; k++) {
			done = true; 	// set true in case no swaps made, exit subroutine
			for (int i = 0; i < a.length - k; i++) {
				if (a[i] > a[i + 1]) {
					ArrayUtility.swapElements(a, i, i + 1);
					done = false;	// continue since swap was made
				}
			}
			for (int i = a.length - k; i > 0;  i--) {
				if (a[i] < a[i - 1]) {
					ArrayUtility.swapElements(a, i, i - 1);
					done = false;	// continue since swap was made
				}
			}
		}
	}
	
	// Selection sort iterates thru i (0 -> n-1), swapping the min element with i.
	// Worst case O(n^2), Best case is also O(n^2) when array already sorted.
	// Example: Given a stack of cards, find smallest in the stack, put first, 
	// find the next smallest in the stack, put second, continue until stack is empty.
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < a[min]) min = j;
			if (min != i) ArrayUtility.swapElements(a, i, min);
		}
	}

	// Worst case O(n^2), best case O(n) exit.
	// Insertions sort smaller partitions
	// Example: Given a stack of cards, pick and insert into a separate stack,
	// pick next card in stack and insert in sorted order, pick next and place
	// in sorted order, continue until stack of cards is empty.
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j, temp = a[i];		// Instead of swapping, save value to be placed in order into temp
			// Move all values greater than a[i] (temp) upward
			for (j = i; j > 0 && temp < a[j - 1]; j--)
				a[j] = a[j - 1];	// Move greater values up 
			a[j] = temp;
		}
	}

	// Insertion sort with variable step size.
	// Elements far away from in-order index reach sorted index faster by skipping positions.
	// As opposed to moving 1 position at a time.
	// Step/Gap size is h
	// Here, halve step size each iteration
	// Alternatively Shell's 2.2 factor and Knuth's 3x+1 sequence.
	public static void shellShort(int[] a) {
		for (int h = a.length / 2; h >= 1; h /= 2) {
			for (int i = h; i < a.length; i++) {
				int j, temp = a[i];
				for (j = i; j >= h && temp < a[j - h]; j-= h) // >= h or do > (h - 1)
					a[j] = a[j - h];
				a[j] = temp;
			}
		}
	}
	
	// O(log n)
	// Merge Sort uses a Merge function which takes as input
	// two sorted collections and returns the combined sorted collection.
	// The Merge step takes O(n + m) time.
	// Two sorted collection can be easily combined into a single sorted collection in linear time.
	// Notice that a collection of size 1 is sorted.
	// So partition the array of size n into n partitions size of 1.
	// Recursively merge these sorted partitions into a single sorted collection.
	
	// [10,9,8,7,6,5,4,3,2,1]        				       (Unsorted collection)
	// [10,9,8,7,6]		[5,4,3,2,1] 				  	   (Partition)
	// [10,9]	[8,7,6]	  [5,4]	 [3,2,1] 			  	   (Partition)
	// [10]	  [9]	[8]	  [7,6]	 [5]  [4]  [3]	[2,1] 	   (Partition)
	
	// Here, [10] [9] [8] etc. are sorted, so they can be merged with another sorted array.
	// Other partitions such as [7,6] and [2,1] still need to be partitioned
	// into a partition of size 1 which is sorted.
	
	// [9,10]	[8]   [7]	[6]	  [4,5]	   [3]	 [2]   [1] (Merge, Partition)
	// [8,9,10] 	[6,7] 	[3,4,5] 	[1,2] 			   (Merge)
	// [6,7,8,9,10] 	[1,2,3,4,5] 					   (Merge)
	// [1,2,3,4,5,6,7,8,9,10] 							   (Merge complete, the collected is sorted.)
	
	// Could possibly change "partition of size 1" is sorted base case into
	// a case where if partition is size <= 20, do insertion sort on the partitions, and merge.
	// This should be faster because of the smaller constant factor,
	// that is, O(n^2) < O(n log n) for sufficiently small n.
	public static int[] mergeSort(int[] a) {
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
	public static void quickSort(int[] a, int lo, int hi) {
		int i = lo, j = hi;
		int pivot = a[(int) Math.floor((lo + hi) / 2)];
		while (i <= j) {
			if (a[i] < pivot) { i++; continue; }
			if (a[j] > pivot) { j--; continue; }
			if (i <= j) ArrayUtility.swapElements(a, i++, j--);
		}
		if (lo < j) quickSort(a, lo, j);
		if (i < hi) quickSort(a, i, hi);
	}
	
	// Simple modification of QuickSort.
	// Utilize Insertion sort for partitions of size n <= 20.
	// Insertion sort has constant factor. Faster for very small collections.
	public static void insQuickSort(int[] a, int lo, int hi) {
		if (a.length <= 100) { insertionSort(a); return;}
		int i = lo, j = hi;
		int pivot = a[(int) Math.floor((lo + hi) / 2)];
		while (i <= j) {
			if (a[i] < pivot) { i++; continue; }
			if (a[j] > pivot) { j--; continue; }
			if (i <= j) ArrayUtility.swapElements(a, i++, j--);
		}
		if (lo < j) insQuickSort(a, lo, j);
		if (i < hi) insQuickSort(a, i, hi);
	}
	
	
}
