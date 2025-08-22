import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    static int binary_search(int[] arr, int target){
int left=0,right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(target==arr[mid]){
                return mid;
            } else if (target<arr[mid]) {
                right = mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
        }

        static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
            }
            arr[j + 1] = key;
        }
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
    public double sort_time(int[] arr) {
        long start = System.nanoTime();
        insertionSort(arr);
        long end = System.nanoTime();
        double cpu_time_based=(end - start)/1e6;
        return cpu_time_based;
    }
    static void writeInputFile(String filename, int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(arr.length + "\n");
        for (int value : arr)
            bw.write(value + " ");
        bw.close();
    }
   static int rec(int[] arr,int st,int end,int target){
        if(st>end)return -1; 
       int mid=(st+end)/2;
       if(target==arr[mid]){
          return mid;
       } else if (target<arr[mid]) {
         return rec(arr,st,mid-1,target);
       }else {
           return rec(arr,mid+1,end,target);
       }
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int[] arr = null;
        Random rand = new Random();

        try {
            System.out.print("enter no.of elements-> ");
            n = Integer.parseInt(input.readLine());
            arr = new int[n];

            BufferedWriter writer = new BufferedWriter(new FileWriter("ipt.txt"));
            writer.write(n + "\n");
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(100);
                writer.write(arr[i] + " ");
            }
            writer.close();
            System.out.println("I/p file 'input.txt' created");
        } catch (IOException e) {
            System.out.println("Error -> " + e.getMessage());
            return;
        } 
       
        System.out.print("Enter a target no.-> ");
        int target = sc.nextInt();
        int[] best_case = new int[n];
        int[] worst_case = new int[n];
        int[] avg_case = new int[n];

        for (int i = 0; i < n; i++) {
            best_case[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            avg_case[i]=i;
        }
        for (int i = 0; i < n; i++) {
            worst_case[i] = n - i - 1;
        }
        BinarySearch bs = new BinarySearch();

        insertionSort(arr);
        System.out.println("Index of target->"+rec(arr,0,arr.length-1,target));
       System.out.printf("Best case -> %.6f ms%n", bs.sort_time(best_case));
      
        System.out.println("Index of target->"+rec(arr,0,arr.length-1,target));
        System.out.printf("avg case-> %.6f ms%n", bs.sort_time(avg_case));

        sort_ascending(arr, n);
        reverse_array(arr, n);
        
        System.out.println("Index of target->"+rec(arr,0,arr.length-1,target));

        System.out.printf("worst case -> %.6f ms%n", bs.sort_time(worst_case));
        System.out.println();
        target++;
        sc.close();
    }
}