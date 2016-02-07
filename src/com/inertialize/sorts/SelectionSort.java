package com.inertialize.sorts;

import com.inertialize.Sortable;

// Selection sort iterates thru i (0 -> n-1), swapping the min element with i.
// Worst case O(n^2), Best case is also O(n^2) when array already sorted.
// Example: Given a stack of cards, find smallest in the stack, put first, 
// find the next smallest in the stack, put second, continue until stack is empty.
public class SelectionSort extends Sortable {

	@Override
	public void sort() {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < a[min]) min = j;
			if (min != i) swap(i, min);
		}
	}

}
