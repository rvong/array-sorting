package com.inertialize.sorts;

import com.inertialize.Sortable;

// Worst case O(n^2), best case O(n) exit.
// Insertions sort smaller partitions
// Example: Given a stack of cards, pick and insert into a separate stack,
// pick next card in stack and insert in sorted order, pick next and place
// in sorted order, continue until stack of cards is empty.
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
