package com.inertialize.sorts;

import java.util.Arrays;

import com.inertialize.Sortable;

// Multi-threaded sort-merge.
public class JavaParallelSort extends Sortable {

	@Override
	public void sort() {
		Arrays.parallelSort(a);
	}

}
