package com.inertialize.sorts;

import com.inertialize.Sortable;

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
