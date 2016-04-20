# array-sorting
Java (Eclipse project)  

Sorting Algorithms:  
  Selection Sort  
  BubbleSort  
  CombSort  
  ShakerSort  
  InsertionSort  
  ShellSort  
  MergeSort  
  QuickSort  

Hybrid:  
	Use Insertion sort for very small n <= 100 arrays to speed up sorting for O(n log n) sorting algorithms with higher constant factor (QuickSort, MergeSort).  
	InsertionMergeSort  
	InsertionQuickSort  

Also times Java's built-in sorting algorithms:  
Arrays.sort() Dual pivot quick sort for primitive types. Merge sort for Object types.  
Arrays.parallelSort() Multithreaded sort-merge.  

To do:  
	Radix Sort

# Sample Output
	TEST: ARRAYUTILITY
	====================
	TEST: FILL
	0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19
	TEST: REVERSE
	19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0
	TEST: SHUFFLE
	19,18,1,2,11,0,16,17,5,4,9,6,10,3,14,8,15,13,12,7
	TEST: FILL RANDOM (1-9)
	7,8,3,7,9,5,2,7,1,3,1,9,6,5,1,5,4,5,4,3
	TEST: ISSORTED
	Array is Not Sorted
	(SORTING)
	Array is Sorted
	
	SMALL ARRAY TEST
	Sorting Algorithm: SelectionSort       	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 33.1933 ms
	Sorting Algorithm: BubbleSort          	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 57.1535 ms
	Sorting Algorithm: ShakerSort          	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 42.2894 ms
	Sorting Algorithm: CombSort            	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 3.7146 ms
	Sorting Algorithm: InsertionSort       	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 21.3931 ms
	Sorting Algorithm: ShellSort           	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 9.2356 ms
	Sorting Algorithm: MergeSort           	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 3.1618 ms
	Sorting Algorithm: InsertionMergeSort  	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 6.6169 ms
	Sorting Algorithm: QuickSort           	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 1.8988 ms
	Sorting Algorithm: CountingSort        	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 1.8664 ms
	Sorting Algorithm: InsertionQuickSort  	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 3.5263 ms
	Sorting Algorithm: JavaSort            	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 1.0048 ms
	Sorting Algorithm: JavaParallelSort    	 Num. Elements: 5000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 0.7106 ms
	
	LARGE ARRAY TEST
	Sorting Algorithm: CombSort            	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 849.8053 ms
	Sorting Algorithm: ShellSort           	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 1134.7425 ms
	Sorting Algorithm: MergeSort           	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 1229.9764 ms
	Sorting Algorithm: InsertionMergeSort  	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 927.3051 ms
	Sorting Algorithm: QuickSort           	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 634.2195 ms
	Sorting Algorithm: InsertionQuickSort  	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 604.8444 ms
	Sorting Algorithm: JavaSort            	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 509.0135 ms
	Sorting Algorithm: JavaParallelSort    	 Num. Elements: 5000000	 Sorted: Yes	 Match Sorted Array: Yes	 Elapsed Time: 229.1571 ms
	
