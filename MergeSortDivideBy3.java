import java.io.*;
import java.util.*;

public class MergeSortDivideBy3 {

    static void mSort(int l, int mid, int h, int arr[]) {
        int i = l, j = mid + 1, k = l;
        int b[] = new int[arr.length];

        while (i <= mid && j <= h) {
            if (arr[i] < arr[j]) {
                b[k++] = arr[i++];
            } else {
                b[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            b[k++] = arr[i++];
        }

        while (j <= h) {
            b[k++] = arr[j++];
        }

        for (int m = l; m <= h; m++) {
            arr[m] = b[m];
        }
    }

    static void mergeSort3(int arr[], int low, int high) {
        if (low < high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = low + 2 * (high - low) / 3;

            mergeSort3(arr, low, mid1);
            mergeSort3(arr, mid1 + 1, mid2);
            mergeSort3(arr, mid2 + 1, high);

            mSort(low, mid1, mid2, arr);
            mSort(low, mid2, high, arr);
        }
    }

    static long testCase(int arr[]) {
        long startTime = System.nanoTime();
        mergeSort3(arr, 0, arr.length - 1);
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        int n = 10000; 

        
        int bestArr[] = new int[n];
        for (int i = 0; i < n; i++) bestArr[i] = i + 1;

        
        int worstArr[] = new int[n];
        for (int i = 0; i < n; i++) worstArr[i] = n - i;

        
        int avgArr[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) avgArr[i] = rand.nextInt(n);

        
        long bestTime = testCase(Arrays.copyOf(bestArr, n));
        long worstTime = testCase(Arrays.copyOf(worstArr, n));
        long avgTime = testCase(Arrays.copyOf(avgArr, n));

    
        System.out.println("--- Time Complexity Test for Merge Sort (3-way) ---");
        System.out.println("Best Case   (sorted array):        " + bestTime + " ns (" + (bestTime / 1_000_000.0) + " ms)");
        System.out.println("Average Case(random array):        " + avgTime + " ns (" + (avgTime / 1_000_000.0) + " ms)");
        System.out.println("Worst Case  (reverse sorted array):" + worstTime + " ns (" + (worstTime / 1_000_000.0) + " ms)");

    }
}
