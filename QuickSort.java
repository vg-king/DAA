import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class QuickSort {
    public static int Partition(int arr[],int low,int high){
        int temp;
        int i = low+1;
        int j = high;
        int pivot = arr[low];
        while (i <= high && arr[i] < pivot) {
            i++;
        }
        while (j >= low && arr[j] > pivot) {
            j--;
        }
        if (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        } else {
            temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;
        }
        return j;
        
    }
    public static void QuickSortt(int arr[],int low,int high){
        if (low<high) {
            int q = Partition(arr, low, high);
            QuickSortt(arr, low, q-1);
            QuickSortt(arr, q+1, high);

        }
    }
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int n = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] nums = line.trim().split("\\s+");
                for (String num : nums) {
                    if (!num.isEmpty()) arr[n++] = Integer.parseInt(num);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        int[] bestArr = Arrays.copyOf(arr, n);
        long startBest = System.nanoTime();
        QuickSortt(bestArr, 0, n - 1);
        long endBest = System.nanoTime();
        System.out.println("Best/Avg case time: " + (endBest - startBest) + " ns");
        int[] worstArr = Arrays.copyOf(arr, n);
        Arrays.sort(worstArr);
        long startWorst = System.nanoTime();
        QuickSortt(worstArr, 0, n - 1);
        long endWorst = System.nanoTime();
        System.out.println("Worst case time: " + (endWorst - startWorst) + " ns");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (int i = 0; i < n; i++) {
                bw.write(bestArr[i] + " ");
            }
            bw.close();
            System.out.println("Sorted array written to output.txt");
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
