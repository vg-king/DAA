import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TerniarySearch {

    public static void insertionSorting(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
    }

    public static void writeArrayToFile(String filename, int[] arr) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        bw.close();
    }

    public static int[] readArrayFromFile(String filename, int n) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        String[] parts = line.trim().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        br.close();
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] bestArr = new int[n];
        int[] worstArr = new int[n];
        int[] avgArr = new int[n];

        for (int i = 0; i < n; i++) bestArr[i] = i;
        for (int i = 0; i < n; i++) worstArr[i] = n - 1 - i;
        for (int i = 0; i < n; i++) avgArr[i] = (int) (Math.random() * 100);

        try {
            writeArrayToFile("best.txt", bestArr);
            writeArrayToFile("worst.txt", worstArr);
            writeArrayToFile("average.txt", avgArr);

            int[] bestFromFile = readArrayFromFile("best.txt", n);
            int[] worstFromFile = readArrayFromFile("worst.txt", n);
            int[] avgFromFile = readArrayFromFile("average.txt", n);

            long start, end;

            start = System.nanoTime();
            insertionSorting(bestFromFile);
            end = System.nanoTime();
            long bestTime = end - start;

            start = System.nanoTime();
            insertionSorting(worstFromFile);
            end = System.nanoTime();
            long worstTime = end - start;

            start = System.nanoTime();
            insertionSorting(avgFromFile);
            end = System.nanoTime();
            long avgTime = end - start;

            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

            out.write("--- Best Case ---\n");
            out.write("Sorted: " + Arrays.toString(bestFromFile) + "\n");
            out.write("Time: " + bestTime + " ns\n\n");

            out.write("--- Worst Case ---\n");
            out.write("Sorted: " + Arrays.toString(worstFromFile) + "\n");
            out.write("Time: " + worstTime + " ns\n\n");

            out.write("--- Average Case ---\n");
            out.write("Sorted: " + Arrays.toString(avgFromFile) + "\n");
            out.write("Time: " + avgTime + " ns\n");

            out.close();

            System.out.println("\n--- Output also saved to 'output.txt' ---\n");

            System.out.println("--- Best Case ---");
            System.out.println("Sorted: " + Arrays.toString(bestFromFile));
            System.out.println("Time: " + bestTime + " ns");

            System.out.println("\n--- Worst Case ---");
            System.out.println("Sorted: " + Arrays.toString(worstFromFile));
            System.out.println("Time: " + worstTime + " ns");

            System.out.println("\n--- Average Case ---");
            System.out.println("Sorted: " + Arrays.toString(avgFromFile));
            System.out.println("Time: " + avgTime + " ns");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
