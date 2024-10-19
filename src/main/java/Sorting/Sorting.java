package Sorting;

public class Sorting {

    public static void bubblesort(int[] array){

        long startTime = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n^2)");
    }

    public static void selectionSort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap array[minIndex] and array[i]
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        long endTime = System.nanoTime();
        System.out.println("Selection Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n^2)");
    }


    public static void insertionSort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key, to one position ahead
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        long endTime = System.nanoTime();
        System.out.println("Insertion Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n^2)");
    }


    public static void mergeSort(int[] array, int left, int right) {
        long startTime = System.nanoTime();
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
        long endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n log n)");
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        // Merge the temp arrays

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[]
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[]
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }


    public static void quickSort(int[] array, int low, int high) {
        long startTime = System.nanoTime();
        if (low < high) {
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        long endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n log n)");
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void heapSort(int[] array) {
        long startTime = System.nanoTime();
        int n = array.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
        long endTime = System.nanoTime();
        System.out.println("Heap Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n log n)");
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }


    public static void countingSort(int[] array) {
        long startTime = System.nanoTime();
        int max = getMax(array);
        int[] count = new int[max + 1];
        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
        long endTime = System.nanoTime();
        System.out.println("Counting Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n + k)");  // k is the range of input
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void radixSort(int[] array) {
        long startTime = System.nanoTime();
        int max = getMax(array);  // Get the maximum value in the array to determine the number of digits

        // Apply counting sort for each digit. The exp is 10^i where i is the current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
        long endTime = System.nanoTime();
        System.out.println("Radix Sort Time: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(nk)");  // k is the number of digits in the largest number
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];  // Output array to hold sorted values
        int[] count = new int[10];  // There are 10 possible digits (0-9)

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that it contains actual positions of the digits in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array back to the original array
        System.arraycopy(output, 0, array, 0, n);
    }




}
