package com.inertialize.sorts;

import com.inertialize.Sortable;

public class InsertionSort extends Sortable {

	@Override
	public void sort() {
		for (int i = 1; i < a.length; i++) {
			int j, temp = a[i];		// Instead of swapping, save value to be placed in order into temp
			// Move all values greater than a[i] (temp) upward
			for (j = i; j > 0 && temp < a[j - 1]; j--)
				a[j] = a[j - 1];	// Move greater values up 
			a[j] = temp;
		}
	}
}
