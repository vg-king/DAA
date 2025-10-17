import java.util.*;

public class Lab7_1 {
    static int find(int[] V, int k) {
        if (V[k] == -1)
            return k;
        return find(V, V[k]);
    }

    static int kmcst(int wt[][], int n, int[] V) {
        Arrays.fill(V, -1);
        int cost = 0, edges = 0;

        while (edges < n - 1) {
            int min = (int) 1e9, a = -1, b = -1;

            // Find minimum edge
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (wt[u][v] < min) {
                        min = wt[u][v];
                        a = u;
                        b = v;
                    }
                }
            }

            if (a == -1 || b == -1) break; // No more edges

            int x = find(V, a);
            int y = find(V, b);

            if (x != y) {
                V[x] = y;
                cost += min;
                edges++;
            }

            wt[a][b] = wt[b][a] = (int) 1e9; // mark edge used
        }

        if (edges < n - 1)
            System.out.println("Graph is disconnected!");
        
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices -> ");
        int n = sc.nextInt();

        int[][] wt = new int[n][n];
        System.out.println("Enter weight adjacency matrix -> ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                wt[i][j] = sc.nextInt();

        int[] V = new int[n];
        int cost = kmcst(wt, n, V);
        System.out.println("Minimum cost of Spanning Tree -> " + cost);
    }
}
