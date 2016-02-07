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
Generalize to Object (Templates)  
Distribution Sorts (Counting, Bucket, Radix)  


# Sample Output
    TEST: ARRAYUTILITY
    ====================
    TEST: FILL
    0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19
    TEST: REVERSE
    19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0
    TEST: SHUFFLE
    16,15,12,17,1,6,0,8,19,18,9,2,14,13,5,3,7,10,11,4
    TEST: FILL RANDOM (1-9)
    7,2,7,7,4,6,2,4,8,5,8,4,1,2,8,1,1,5,8,7
    TEST: ISSORTED
    Array is Not Sorted
    (SORTING)
    Array is Sorted

    SMALL ARRAY TEST
    Sorting Algorithm: SelectionSort       	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 18.3663 ms
    Sorting Algorithm: BubbleSort          	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 46.4194 ms
    Sorting Algorithm: ShakerSort          	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 38.6472 ms
    Sorting Algorithm: CombSort            	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 3.5224 ms
    Sorting Algorithm: InsertionSort       	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 16.0963 ms
    Sorting Algorithm: ShellSort           	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 3.5991 ms
    Sorting Algorithm: MergeSort           	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 3.2164 ms
    Sorting Algorithm: InsertionMergeSort  	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 3.6838 ms
    Sorting Algorithm: QuickSort           	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 4.1377 ms
    Sorting Algorithm: InsertionQuickSort  	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 2.227 ms
    Sorting Algorithm: JavaSort            	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 4.9952 ms
    Sorting Algorithm: JavaParallelSort    	 Num. Elements: 5000	 Sorted: Yes	 Elapsed Time: 0.7417 ms

    LARGE ARRAY TEST
    Sorting Algorithm: CombSort            	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 860.0371 ms
    Sorting Algorithm: ShellSort           	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 1013.4423 ms
    Sorting Algorithm: MergeSort           	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 1241.8945 ms
    Sorting Algorithm: InsertionMergeSort  	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 885.4528 ms
    Sorting Algorithm: QuickSort           	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 664.9781 ms
    Sorting Algorithm: InsertionQuickSort  	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 618.6992 ms
    Sorting Algorithm: JavaSort            	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 587.5992 ms
    Sorting Algorithm: JavaParallelSort    	 Num. Elements: 5000000	 Sorted: Yes	 Elapsed Time: 297.3114 ms
