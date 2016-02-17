package com.inertialize.sorts;

import java.text.DecimalFormat;
import com.inertialize.Sortable;


/**
 * 
 * @author richv
 * 
 * Counting sort worst-case O(n + k) where n is size of input, k is # where keys lie in 0..k-1
 * Allocates array of size k + 1 (fit 0, fit k)
 * E.g. if A is an array with 1,000 elements, with values ranging from 0 - 100,000 inclusive
 * Allocate array of size 100,001 (so that 0 and 100,000 fit)
 * Iterate through input N, increment count A[i] for each integer value,
 * 	where i is the integer value and A[i] is the # times the value occurs in N.
 * Iterate again to build result array.
 *
 *	Ideal for sorting collections of non-negative integers with small values.
 *	If range of keys is much greater than size of N => space inefficient.
 */
public class CountingSort extends Sortable {

	private int maxVal = 5000;
	
	public int getMaxval() {
		return maxVal;
	}

	public void setMaxval(int maxVal) {
		this.maxVal = maxVal;
	}
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		System.out.println("Call int[] countingSort(int[] a, int maxVal)");
	}
	
	// Fill count times implementation for integers
	public int[] countingSort(int[] a, int maxVal) {
		int[] counts = new int[maxVal + 1];		// holds value counts e.g. if there are 5 zeroes, a[0] = 5;

		for (int i = 0; i < a.length; i++)	// count the values
			counts[a[i]]++;

		int[] result = new int[a.length];	// alloc array for results (print out values in order count times)
		int r = 0;	// index for result[]
		
		for (int i = 0; i < counts.length; i++) { // fill results r times
			for (int j = 0; j < counts[i]; j++)
				result[r++] = i; 
		}
		return result;
	}

	// Fill
	public int[] countingSort2(int[] a, int maxVal) {
		// Count frequencies ("histogram")
		int[] count = new int[maxVal + 1];
		for (int i = 0; i < a.length; i++)
			count[a[i]]++;	// incr. count for each key a[i].
		
		// transform histogram to indexes in result array
		// (starting indexes, increment when building result)
		int total = 0;
		for (int i = 0; i < count.length; i++) {
			int oldCount = count[i];
			count[i] = total;
			total += oldCount;
		}
		
		// iterate through input, place into correct position
		// by lookup of count[key]. Then incr. count[key] for
		// next pos. if there are more w/ same key.
		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++) {
			result[count[a[i]]] = a[i];
			count[a[i]] += 1;
		}
		return result;
	}
	
	@Override
	public void test(int[] sortedTestArray) {
		long time = System.nanoTime();
		a = this.countingSort2(a, this.maxVal);
		double elapsedMs = (double)((System.nanoTime() - time) / 1000000.0);
		
		System.out.println(
				"Sorting Algorithm: " + String.format("%-20s", this.getClass().getSimpleName())
				+ "\t Num. Elements: " + a.length 
				+ "\t Sorted: " + (isSorted() ? "Yes" : "No")
				+ "\t Match Sorted Array: " + (matchSorted(sortedTestArray) ? "Yes" : "No")
				+ "\t Elapsed Time: " + (new DecimalFormat("0.00##").format(elapsedMs)) + " ms");
	}
}
