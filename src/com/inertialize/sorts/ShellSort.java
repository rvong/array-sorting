package com.inertialize.sorts;

import com.inertialize.Sortable;

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
