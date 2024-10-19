package org.example;

import Sorting.Sorting;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");


        Scanner scanner = new Scanner(System.in);
        // Ask the user for the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        // Create the array with the specified size
        int[] array = new int[size];
        // Loop to get user input for array values
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the value for element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        // Display the entered array
        System.out.println("You entered the following array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        int choice;
        do{
        System.out.println("\nChoose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Merge Sort");
        System.out.println("6. Radix Sort");
        System.out.println("7. Heap Sort");
        System.out.println("8. exit");

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        // Apply the selected sorting algorithm
        switch (choice) {
            case 1:
                Sorting.bubblesort(array);
                System.out.println("Array sorted using Bubble Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            case 2:
                Sorting.selectionSort(array);
                System.out.println("Array sorted using Selection Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            case 3:
                Sorting.insertionSort(array);
                System.out.println("Array sorted using Insertion Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            case 4:
                Sorting.quickSort(array,0,array.length-1);
                System.out.println("Array sorted using Quick Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            case 5:
                Sorting.mergeSort(array,0,array.length-1);
                System.out.println("Array sorted using Merge Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            case 6:
                Sorting.radixSort(array);
                System.out.println("Array sorted using Radix Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            case 7:
                Sorting.heapSort(array);
                System.out.println("Array sorted using Heap Sort:");
                // Example input array
                System.out.println("Sorted Array: " + Arrays.toString(array));
                break;
            default:
                System.out.println("Invalid choice, no sorting performed.");
                break;
        }}while(choice!=8);

        scanner.close();

    }
}