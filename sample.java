import java.io.*;
import java.util.*;

public class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers you want to read from file: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line = br.readLine();
            String[] nums = line.trim().split("\\s+");
            for (int i = 0; i < n && i < nums.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.print("The content of the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        int duplicateCount = 0;
        int maxFreq = 0;
        int mostRepeating = arr[0];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) duplicateCount++;
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostRepeating = entry.getKey();
            }
        }
        System.out.println("Total number of duplicate values = " + duplicateCount);
        System.out.println("The most repeating element in the array = " + mostRepeating);
    }
}
