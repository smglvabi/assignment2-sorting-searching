public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone();

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            int[] arr = sorter.generateRandomArray(size);

            System.out.println("\nArray size: " + size);

            long basicTime = measureSortTime(arr, "basic");
            long advancedTime = measureSortTime(arr, "advanced");

            sorter.advancedSort(arr); // для бинарного поиска

            long searchTime = measureSearchTime(arr, arr[size / 2]);

            System.out.println("Bubble Sort time: " + basicTime);
            System.out.println("Merge Sort time: " + advancedTime);
            System.out.println("Binary Search time: " + searchTime);
        }
    }
}