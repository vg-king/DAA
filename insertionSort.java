import java.util.Arrays;
import java.util.Scanner;


public class insertionSort {
    public static void insertionSorting(int arr[]){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int Bestarr[] = new int[n];
        int worstarr[] = new int[n];
        int avgarr[] = new int[n];
  for (int i = 0; i < n; i++) {
      Bestarr[i] = i;
        }
        for (int i = 0; i < n; i++) {
            worstarr[i] = n - 1-i;
        }
 for (int i = 0; i < n; i++) {
            avgarr[i] = (int)(Math.random() * 100);
        }

        long start, end;

        start = System.nanoTime();
        insertionSorting(Bestarr);
      end = System.nanoTime();
      System.out.println("Value= "+Arrays.toString(Bestarr));
        System.out.println("Best case time= " + (end - start) + "ns");
        System.out.println("Value= "+Arrays.toString(worstarr));
 start = System.nanoTime();
        insertionSorting(worstarr);
        end = System.nanoTime();
      
      System.out.println("Worst case time= " + (end - start) + "ns");
      System.out.println("Value= "+Arrays.toString(avgarr));
      start = System.nanoTime();
      insertionSorting(avgarr);
      end = System.nanoTime();
        System.out.println("Average case time= " + (end - start) + "ns");

    }
}
