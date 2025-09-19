import java.io.*;
import java.util.Random;

public class QuickSort {

     void quick(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot_index = partition(arr, left, right);
        quick(arr, left, pivot_index - 1); 
        quick(arr, pivot_index + 1, right);
    }

     int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left + 1; int j=right;
        while(arr[i]<pivot){
            i++;
        }
        while(arr[j]>pivot){
            j--;
        }
        if (i<j) {
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;            
        }
            int temp = arr[right];
            arr[right] = arr[j];
            arr[j] = temp;
            return j;
        
    }

     void copy_array(int[] dest, int[] src, int n) {
        for (int i = 0; i < n; i++) dest[i] = src[i];
    }

     void sort_ascending(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

     void reverse_array(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            int t = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = t;
        }
    }

    static void writeInputFile(String filename, int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(arr.length + "\n");
        for (int value : arr)
            bw.write(value + " ");
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter no.of elements-> ");
        int n = Integer.parseInt(input.readLine());

        int[] original = new int[n];
        int[] arr = new int[n];
        Random rand = new Random();

        BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
        writer.write(n + "\n");
        for (int i = 0; i < n; i++) {
            original[i] = rand.nextInt(100);
            writer.write(original[i] + " ");
        }
        writer.close();
        System.out.println("I/p file 'input.txt' created");

        QuickSort qs = new QuickSort();

        qs.copy_array(arr, original, n);
        long start = System.nanoTime();
        qs.quick(arr, 0, n - 1);
        long end = System.nanoTime();
        double avgTime = (end - start) / 1e6;
        System.out.printf("Avg case -> %.6f ms%n", avgTime);

        qs.copy_array(arr, original, n);
        qs.sort_ascending(arr, n);
        start = System.nanoTime();
        qs.quick(arr, 0, n - 1);
        end = System.nanoTime();
        double bestTime = (end - start) / 1e6;
        System.out.printf("best case-> %.6f ms%n", bestTime);

        qs.copy_array(arr, original, n);
        qs.sort_ascending(arr, n);
        qs.reverse_array(arr, n);
        start = System.nanoTime();
        qs.quick(arr, 0, n - 1);
        end = System.nanoTime();
        double worstTime = (end - start) / 1e6;
        System.out.printf("worst case -> %.6f ms%n", worstTime);

        System.out.println("Sorted o/p->");
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}