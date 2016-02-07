package com.inertialize.sorts;

import com.inertialize.Sortable;

/* Eliminate Turtles like Shaker/Cocktail sort
 * 
 */
public class CombSort extends Sortable {

	@Override
	public void sort() {
		int h = a.length;
		boolean swapped = true;
		while (h > 1 || swapped) {
			if (h > 1) h = (int)(h/1.3);
			swapped = false;
			for (int i = 0; i + h < a.length; i++) {
				if (a[i] > a[i + h]) {
					swap(i, i + h);
					swapped = true;	// continue since swap was made
				}
			}
		}
	}

}
