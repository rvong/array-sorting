package com.inertialize;

import java.util.Arrays;
import java.util.List;

import com.inertialize.sorts.*;

public class Main {
	private static final int SMALL = 5000, LARGE = 5000000;
	
	private static void testSort(List<Sortable> sorts, int[] testArray) {
		for (Sortable sort : sorts) {
			sort.copy(testArray);
			sort.test();
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Java uses dual pivot QuickSort for primitive types (where the key is the element's value). MergeSort (stable) for Object types.
		 * ParallelSort is multithreaded.
		 */
		testArrayUtility();		
		
		Sortable selectionSort = new SelectionSort();
		Sortable bubbleSort = new BubbleSort();
		Sortable shakerSort = new ShakerSort();
		Sortable combSort = new CombSort();
		Sortable insertionSort = new InsertionSort();
		Sortable shellSort = new ShellSort();
		Sortable mergeSort = new MergeSort();
		Sortable insMergeSort = new InsertionMergeSort();
		Sortable quickSort = new QuickSort();
		Sortable insQuickSort = new InsertionQuickSort();
		Sortable javaSort = new JavaSort();
		Sortable javaParallelSort = new JavaParallelSort();
		
		List<Sortable> sorts = Arrays.asList(selectionSort, bubbleSort, shakerSort, combSort, insertionSort, shellSort, mergeSort, insMergeSort, quickSort, insQuickSort, javaSort, javaParallelSort);
		List<Sortable> fastSorts = Arrays.asList(combSort, shellSort, mergeSort, insMergeSort, quickSort, insQuickSort, javaSort, javaParallelSort);
		
		System.out.println("\nSMALL ARRAY TEST");
		final int[] smallTestArray = new int[SMALL];
		ArrayUtility.fillRandom(smallTestArray, 1, SMALL);
		testSort(sorts, smallTestArray);
		
		System.out.println("\nLARGE ARRAY TEST");
		final int[] largeTestArray = new int[LARGE];
		ArrayUtility.fillRandom(largeTestArray, 1, LARGE);
		testSort(fastSorts, largeTestArray);
	}

	private static void testArrayUtility() {
		int[] a = new int[20];
		
		System.out.println("TEST: ARRAYUTILITY");
		for (int i = 0; i < 20; i++) System.out.print("=");
		System.out.println("");
		
		System.out.println("TEST: FILL");
		ArrayUtility.fill(a);
		ArrayUtility.print(a);
		
		System.out.println("TEST: REVERSE");
		ArrayUtility.reverse(a);
		ArrayUtility.print(a);
		
		System.out.println("TEST: SHUFFLE");
		ArrayUtility.shuffle(a);;
		ArrayUtility.print(a);
		
		System.out.println("TEST: FILL RANDOM (1-9)");
		ArrayUtility.fillRandom(a, 1, 9);
		ArrayUtility.print(a);
		
		System.out.println("TEST: ISSORTED");
		ArrayUtility.printIsSorted(a);
		
		System.out.println("(SORTING)");
		Arrays.sort(a);;
		ArrayUtility.printIsSorted(a);
	}
}



