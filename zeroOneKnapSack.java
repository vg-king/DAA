import java.util.Scanner;

public class zeroOneKnapSack {

    int knapSack(int wt[], int val[], int n, int w) {
        int[] prev = new int[w + 1];

        for (int i = wt[0]; i <= w; i++) {
            prev[i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = w; cap >= 0; cap--) {
                int notTaken = prev[cap];
                int taken = Integer.MIN_VALUE;

                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                prev[cap] = Math.max(notTaken, taken);
            }
        }

        return prev[w];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.print("Enter maximum weight capacity: ");
        int w = sc.nextInt();

        zeroOneKnapSack obj = new zeroOneKnapSack();
        int result = obj.knapSack(wt, val, n, w);

        System.out.println("Maximum value that can be obtained: " + result);

    }
}
