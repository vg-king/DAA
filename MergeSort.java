import java.io.*;
import java.util.Random;  

public class MergeSort {

    static void merge(int[] arr, int left, int right) { 
        if (left >= right) return;

        int mid = (left + right) / 2;
        merge(arr, left, mid);
        merge(arr, mid + 1, right);
        merge_sort(arr, left, mid, right);
    }

    static void merge_sort(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void copy_array(int[] dest, int[] src, int n) {
        for (int i = 0; i < n; i++) dest[i] = src[i];
    }

    static void sort_ascending(int[] arr, int n) {
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

    static void reverse_array(int[] arr, int n) {
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

        copy_array(arr, original, n);
        long start = System.nanoTime();
        merge(arr, 0, n - 1);
        long end = System.nanoTime();
        double avgTime = (end - start) / 1e6;
        System.out.printf("Avg case -> %.6f ms%n", avgTime);

        copy_array(arr, original, n);
        sort_ascending(arr, n);
        start = System.nanoTime();
        merge(arr, 0, n - 1);
        end = System.nanoTime();
        double bestTime = (end - start) / 1e6;
        System.out.printf("best case-> %.6f ms%n", bestTime);

        copy_array(arr, original, n);
        sort_ascending(arr, n);
        reverse_array(arr, n);
        start = System.nanoTime();
        merge(arr, 0, n - 1);
        end = System.nanoTime();
        double worstTime = (end - start) / 1e6;
        System.out.printf("worst case -> %.6f ms%n", worstTime);

        System.out.println("Sorted o/p->");
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}