import java.util.Arrays;

public class findSecondSmallest {
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

}
