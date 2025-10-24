

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;
        buildMaxHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // root max moved to end
            heapify(arr, i, 0);
        }
    }
    private void buildMaxHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    private void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverseArray(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
    public void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        Random rand = new Random();
        HeapSort hs = new HeapSort();
        // Writing random numbers into file1.txt
        FileWriter fw = new FileWriter("file1.txt");
        for (int i = 0; i < n; i++) {
            int val = rand.nextInt(100); // values from 0 to 99
            fw.write(val + " ");
        }
        fw.close();

        // Reading values from file1.txt into array
        Scanner fileReader = new Scanner(new File("file1.txt"));
        for (int i = 0; i < n && fileReader.hasNextInt(); i++) {
            arr[i] = fileReader.nextInt();
        }
        fileReader.close();
        System.out.print("Original Array from file1: ");
        for (int val : arr) System.out.print(val + " ");
        System.out.println();

        // AVERAGE CASE
        long start = System.nanoTime();
        hs.heapSort(arr);
        long end = System.nanoTime();
        System.out.print("Sorted Array (Average Case): ");
        for (int val : arr) System.out.print(val + " ");
        double averageTime = (end - start) / 1e9;
        System.out.printf("\nAverage case time: %f sec\n", averageTime);

        // Save sorted array to file2.txt
        FileWriter sortedWriter = new FileWriter("file2.txt");
        for (int val : arr) {
            sortedWriter.write(val + " ");
        }
        sortedWriter.close();
        // BEST CASE
        start = System.nanoTime();
        hs.heapSort(arr);
        end = System.nanoTime();
        System.out.print("\nSorted Array (Best Case): ");
        for (int val : arr) System.out.print(val + " ");
        double bestTime = (end - start) / 1e9;
        System.out.printf("\nBest case time: %f sec\n", bestTime);

        // WORST CASE
        reverseArray(arr, n);
        start = System.nanoTime();
        hs.heapSort(arr);
        end = System.nanoTime();
        System.out.print("\nSorted Array (Worst Case): ");
        for (int val : arr) System.out.print(val + " ");
        double worstTime = (end - start) / 1e9;
        System.out.printf("\nWorst case time: %f sec\n", worstTime);
        System.out.printf("\nAverage case time: %f sec\n", averageTime);
        System.out.printf("\nBest case time: %f sec\n", bestTime);
    }
}