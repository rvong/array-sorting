package com.inertialize.sorts;

import com.inertialize.Sortable;

// Bubble sort swaps element i with subsequent element i+1 if i > i+1 until the array is sorted.
// The largest element "bubbles" to the end of the array. Reduce search limit k by 1 each iteration since
// it's known that the highest element is in the correct position after each iteration.
// Worst case is O(n^2). Best case is O(n) by exiting the subroutine if no swaps are made.
public class BubbleSort extends Sortable {

	@Override
	public void sort() {
		boolean swapped = true;
		for (int k = 1; k < a.length && swapped; k++) {
			swapped = false; 	// set false, if no swaps made, exit since sort complete
			for (int i = 0; i < a.length - k; i++) {
				if (a[i] > a[i + 1]) {
					swap(i, i + 1);
					swapped = true;	// continue since swap was made
				}
			}
		}
	}
}
