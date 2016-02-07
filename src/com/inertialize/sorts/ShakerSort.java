package com.inertialize.sorts;

import com.inertialize.Sortable;

// bubble sort in both directions. (bubble to end. bubble to beginning)
// solves Turtle and Rabbit problem.
public class ShakerSort extends Sortable {

	@Override
	public void sort() {
		boolean swapped = true;
		for (int k = 1; k < a.length && swapped; k++) {
			swapped = false; 	// set false, if no swaps made exit
			for (int i = 0; i < a.length - k; i++) {
				if (a[i] > a[i + 1]) {
					swap(i, i + 1);
					swapped = true;	// continue since swap was made
				}
			}
			for (int i = a.length - k; i > 0;  i--) {
				if (a[i] < a[i - 1]) {
					swap(i, i - 1);
					swapped = true;	// continue since swap was made
				}
			}
		}
	}

}
