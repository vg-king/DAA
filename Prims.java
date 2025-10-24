
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;
public class Prims {
    static final int INF = 999999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Vertices: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        System.out.println("Enter the Cost Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the Starting Vertex: ");
        int start = sc.nextInt() - 1; // converting to 0-based index
        prims(cost, n, start);
        sc.close();
    }
    static void prims(int[][] cost, int n, int start) {
        int[] dist = new int[n];
        int[] pred = new int[n];
        boolean[] visited = new boolean[n];
        int[][] T = new int[n][n];
        int totalCost = 0;
        // Initialization
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            pred[i] = -1;
            visited[i] = false;
            for (int j = 0; j < n; j++)
                T[i][j] = 0;
        }
        dist[start] = 0;
        for (int count = 0; count < n - 1; count++) {
            int min = INF, u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }
            if (u == -1)
                break;
            visited[u] = true;
            // Update distances of adjacent vertices
            for (int v = 0; v < n; v++) {
                if (cost[u][v] != 0 && !visited[v] && cost[u][v] < dist[v]) {
                    dist[v] = cost[u][v];
                    pred[v] = u;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (pred[i] != -1) {
                T[i][pred[i]] = cost[i][pred[i]];
                T[pred[i]][i] = cost[i][pred[i]];
                totalCost += cost[i][pred[i]];
            }
        }
        System.out.println("\n cost adjacency matrix for min spanning tree");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n total weight of spanning tree calculated" + totalCost);
    }
}