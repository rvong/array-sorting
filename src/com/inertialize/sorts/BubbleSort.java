package com.inertialize.sorts;

import com.inertialize.Sortable;

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
