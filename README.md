Project Overview

This project analyzes the performance of selected sorting and searching algorithms.
The main goal is to compare execution times on arrays of different sizes and understand how theoretical time complexity relates to real performance.

The following algorithms were implemented:

* Bubble Sort (basic sorting)
* Merge Sort (advanced sorting)
* Binary Search (searching)

⸻

Algorithm Descriptions

Bubble Sort
Bubble Sort compares adjacent elements and swaps them if they are in the wrong order. This process repeats until the array is sorted.

Time complexity:
Worst case: O(n²)
Best case: O(n)

⸻

Merge Sort
Merge Sort uses a divide-and-conquer approach. It recursively splits the array into smaller parts, sorts them, and merges the results.

Time complexity:
Best and worst case: O(n log n)

⸻

Binary Search
Binary Search works on a sorted array. It repeatedly divides the search interval in half to find the target element.

Time complexity:
O(log n)

⸻

Experimental Setup

Arrays of three sizes were tested:

Small: 10 elements
Medium: 100 elements
Large: 1000 elements

All arrays were randomly generated.
Execution time was measured using System.nanoTime().

⸻

Results

Array Size: 10
Bubble Sort: 3333 ns
Merge Sort: 5750 ns
Binary Search: 1041 ns

Array Size: 100
Bubble Sort: 157208 ns
Merge Sort: 58125 ns
Binary Search: 1000 ns

Array Size: 1000
Bubble Sort: 2518875 ns
Merge Sort: 88709 ns
Binary Search: 708 ns

⸻

Analysis

Merge Sort performed faster than Bubble Sort on medium and large arrays. This is because Merge Sort has a time complexity of O(n log n), while Bubble Sort has O(n²). As the size of the input increases, Bubble Sort becomes significantly slower.

On very small arrays, Bubble Sort performed slightly better. This happens because Merge Sort has additional overhead from recursion and array copying.

Binary Search showed very small execution times for all array sizes. This is expected because it has logarithmic complexity, meaning its performance changes very slowly as the input size increases.

The experimental results match the theoretical expectations of Big-O complexity.

Binary Search is more efficient than linear search because it reduces the search space by half at each step. However, it requires a sorted array. Without sorting, the algorithm cannot correctly determine which half to search next.

⸻

Screenshots

Program output and test runs should be included in the repository inside the folder:

docs/screenshots/

⸻

Reflection

This project helped me better understand how algorithm efficiency works in practice. While theoretical complexity gives a general idea, actual execution time depends on factors such as implementation details and overhead.

One important observation was that simple algorithms like Bubble Sort can perform reasonably well on small datasets, but they do not scale well. In contrast, Merge Sort maintains stable performance even as the dataset grows.

A challenge during this project was measuring execution time accurately, especially for fast operations like Binary Search, where results can vary due to system timing precision.