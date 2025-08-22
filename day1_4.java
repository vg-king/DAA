import java.util.Scanner;

public class day1_4 {
    public static void exchange(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void rotateRight(int arr[],int p2) {
        for (int i = p2-1; i >0; i--) {
            exchange(arr, i, i-1);
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println("Ente p2: ");
        int p2 = sc.nextInt();
         System.out.print("Before ROTATE: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
        rotateRight(arr, p2);
        System.out.print("After  ROTATE: ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
