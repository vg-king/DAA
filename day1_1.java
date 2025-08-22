

import java.util.Arrays;
import java.util.Scanner;

public class day1_1 {
    public static void findSecondSmallestLargest(int arr[]){
        Arrays.sort(arr);
        int n = arr.length;
        int smallest=arr[0];
        int secondSmallest = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i]!=smallest) {
                secondSmallest =arr[i];
                break;
            }
        }
        int largest = arr[n-1];
        int secondLargest = -1;
        for (int i = n-2; i >= 0; i--) {
            if (arr[i]!=largest) {
                secondLargest = arr[i];
                break;
            }
        }
        if (secondSmallest==-1) {
            System.out.println("No second Smallest");
        }
        else{
            System.out.println("Second smallest: "+secondSmallest);
        }
        if (secondLargest==-1) {
            System.out.println("No second Smallest");
        }
        else{
            System.out.println("Second Largest: "+secondLargest);
        }
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
        findSecondSmallestLargest(arr);
    }
    
}
