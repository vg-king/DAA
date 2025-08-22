import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day1_3 {
    public static void analyzeDuplicates(int arr[]){
        Map<Integer,Integer> mpp = new HashMap<>();
        for (int i : arr) {
            mpp.put(i, mpp.getOrDefault(i,0 )+1);
        }
        int duplicateCount = 0;
        int mostRepeating = -1;
        int maxfre1 = 0;
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            int val = entry.getValue();
            if (val>1) {
                duplicateCount++;
            }if (val>maxfre1) {
                maxfre1 = val;
                mostRepeating=entry.getKey();
            }

        }
        System.out.println("Total duplicate number: "+duplicateCount);
        System.out.println("Most repeating element: "+mostRepeating);
        System.out.println("Max frequency element: "+maxfre1);
    }
    public static void main(String[] args) {
         try {
            Scanner sc = new Scanner(new File("input.txt"));

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            analyzeDuplicates(arr);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
