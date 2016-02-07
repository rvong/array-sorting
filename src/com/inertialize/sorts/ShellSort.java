package com.inertialize.sorts;

import com.inertialize.Sortable;

// Insertion sort with variable step size.
// Elements far away from in-order index reach sorted index faster by skipping positions.
// As opposed to moving 1 position at a time.
// Step/Gap size is h
// Shell's 2.2 factor alternatively Knuth's 3x+1 sequence.
public class ShellSort extends Sortable {

	@Override
	public void sort() {
		for (int h = a.length / 2; h >= 1; h = (int)(h/2.2)) {
			for (int i = h; i < a.length; i++) {
				int j, temp = a[i];
				for (j = i; j >= h && temp < a[j - h]; j-= h) // >= h or do > (h - 1)
					a[j] = a[j - h];
				a[j] = temp;
			}
		}
	}

}
