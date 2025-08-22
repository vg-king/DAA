import java.util.Arrays;
import java.util.Scanner;

public class day1_2 {
    public static int[] prefixSumofArray(int arr[]){
        int prefixSum = 0;
        int newArr[] = new int[arr.length];
        newArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum = newArr[i-1]+arr[i];
            newArr[i] = prefixSum;
        }
        return newArr;
    }
public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        int result[] = prefixSumofArray(arr);
   System.out.println( Arrays.toString(result));
}    
}
