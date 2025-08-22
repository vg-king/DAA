import java.io.*;
import java.util.*;

public class HeapSort {

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line = br.readLine();
            br.close();

            if (line == null || line.isEmpty()) {
                System.out.println("Input file is empty!");
                return;
            }

            String[] parts = line.trim().split("\\s+");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            System.out.println("Original Array: " + Arrays.toString(arr));


            int[] arrBest = Arrays.copyOf(arr, arr.length);     
            Arrays.sort(arrBest);

            int[] arrWorst = Arrays.copyOf(arr, arr.length);    
            Arrays.sort(arrWorst);
            for (int i = 0; i < arrWorst.length / 2; i++) {
                int temp = arrWorst[i];
                arrWorst[i] = arrWorst[arrWorst.length - 1 - i];
                arrWorst[arrWorst.length - 1 - i] = temp;
            }

            int[] arrAvg = Arrays.copyOf(arr, arr.length);      

            long start, end;


            start = System.nanoTime();
            sort(arrBest);
            end = System.nanoTime();
            System.out.println("Best Case Time   : " + (end - start) + " ns");

            start = System.nanoTime();
            sort(arrAvg);
            end = System.nanoTime();
            System.out.println("Average Case Time: " + (end - start) + " ns");

            start = System.nanoTime();
            sort(arrWorst);
            end = System.nanoTime();
            System.out.println("Worst Case Time  : " + (end - start) + " ns");

            System.out.println("\nFinal Sorted Array (from input): " + Arrays.toString(arrAvg));
            sort(arr);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
