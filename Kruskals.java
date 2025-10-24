
import java.util.Scanner;

class Edge {
    int u, v, w;
}
public class Kruskals {
    static final int INF = 999999;
    static int find(int[] parent, int i) {
        while (parent[i] > 0)
            i = parent[i];
        return i;
    }
    static void doUnion(int[] parent, int i, int j) {
        parent[j] = i;
    }
    static void sort(Edge[] edges, int e) {
        for (int i = 0; i < e - 1; i++) {
            for (int j = i + 1; j < e; j++) {
                if (edges[i].w > edges[j].w) {
                    Edge temp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = temp;
                }
            }
        }
    }
    static void KMCST(int[][] w, int n) {
        Edge[] q = new Edge[100];
        int edgeCount = 0;
        int[] parent = new int[20];
        int cost = 0;
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (w[u][v] != 0 && w[u][v] != INF) {
                    q[edgeCount] = new Edge();
                    q[edgeCount].u = u;
                    q[edgeCount].v = v;
                    q[edgeCount].w = w[u][v];
                    edgeCount++;
                }
            }
        }
        sort(q, edgeCount);
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        int i = 0, count = 0;
        System.out.println("\nEdges in Minimum Spanning Tree:");
        while (count < n - 1 && i < edgeCount) {
            Edge e = q[i++];
            int u = find(parent, e.u);
            int v = find(parent, e.v);
            if (u != v) {
                doUnion(parent, u, v);
                System.out.println("Edge (" + e.u + ", " + e.v + ") = " + e.w);
                cost += e.w;
                count++;
            }
        }
        System.out.println("\nMinimum Cost of Spanning Tree = " + cost);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] w = new int[20][20];
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.println("Enter cost adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
                if (w[i][j] == 0)
                    w[i][j] = INF;
            }
        }
        System.out.println("\nKruskal's minimum spanning tree : ");
        KMCST(w, n);
        sc.close();
    }
}