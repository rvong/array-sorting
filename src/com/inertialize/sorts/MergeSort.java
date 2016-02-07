package com.inertialize.sorts;

import java.text.DecimalFormat;
import java.util.Arrays;

import com.inertialize.Sortable;
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
