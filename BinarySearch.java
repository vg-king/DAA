import java.io.*;
import java.util.*;

public class BinarySearch {

    public int binarySearch(int arr[], int key, int low, int high) {
        Arrays.sort(arr);  
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == key) return mid;
        else if (key < arr[mid]) return binarySearch(arr, key, low, mid - 1);
        else return binarySearch(arr, key, mid + 1, high);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String[] arrStr = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(arrStr).mapToInt(Integer::parseInt).toArray();

            int keyBest = Integer.parseInt(br.readLine().trim());
            int keyAvg = Integer.parseInt(br.readLine().trim());
            int keyWorst = Integer.parseInt(br.readLine().trim());
            br.close();

            BinarySearch bs = new BinarySearch();

            long startBest = System.nanoTime();
            int resBest = bs.binarySearch(arr, keyBest, 0, arr.length - 1);
            long endBest = System.nanoTime();
            System.out.println("Best case (key=" + keyBest + ") index: " + resBest + ", time: " + (endBest - startBest) + " ns");

            long startAvg = System.nanoTime();
            int resAvg = bs.binarySearch(arr, keyAvg, 0, arr.length - 1);
            long endAvg = System.nanoTime();
            System.out.println("Average case (key=" + keyAvg + ") index: " + resAvg + ", time: " + (endAvg - startAvg) + " ns");

            long startWorst = System.nanoTime();
            int resWorst = bs.binarySearch(arr, keyWorst, 0, arr.length - 1);
            long endWorst = System.nanoTime();
            System.out.println("Worst case (key=" + keyWorst + ") index: " + resWorst + ", time: " + (endWorst - startWorst) + " ns");

        } catch (IOException e) {
            System.out.println("Error reading input.txt: " + e.getMessage());
        }
    }
}
