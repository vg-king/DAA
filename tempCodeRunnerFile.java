import java.util.*;

public class Prims {

    static class Pair {
        int d;
        int node;

        Pair(int d, int node) {
            this.d = d;
            this.node = node;
        }
    }

    static int prim(int V, ArrayList<ArrayList<Pair>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.d - y.d);
        int[] dist = new int[V];       // Similar to dist[] in Dijkstra
        int[] prev = new int[V];    
        boolean[] mstSet = new boolean[V];

        Arrays.fill(dist, (int) 1e9);
        Arrays.fill(prev, -1);

        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;

            if (mstSet[node]) continue;
            mstSet[node] = true;

            for (Pair neighbor : adj.get(node)) {
                int edgewt = neighbor.d;
                int adjnode = neighbor.node;

                if (!mstSet[adjnode] && edgewt < dist[adjnode]) {
                    dist[adjnode] = edgewt;
                    prev[adjnode] = node;
                    pq.add(new Pair(dist[adjnode], adjnode));
                }
            }
        }

        int totalWeight = 0;
        for (int i = 0; i < V; i++) {
            if (dist[i] != (int) 1e9) {
                totalWeight += dist[i];
            }
        }

        System.out.println("\nEdges in the Minimum Spanning Tree:");
        for (int i = 0; i < V; i++) {
            
            if (prev[i] != -1) {
                System.out.println(prev[i] + " - " + i + " : " + dist[i]);
            }
        }

        System.out.println("Total Weight of MST: " + totalWeight);
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int V = sc.nextInt();

        System.out.println("Enter the number of edges:");
        int E = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v w) where u and v are vertices and w is the weight:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u)); // Undirected graph
        }

        System.out.println("Enter the starting vertex:");
        int S = sc.nextInt();

        prim(V, adj, S);

        sc.close();
    }
}