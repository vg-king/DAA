import java.util.*;

public class Dijkstra {

    static class Pair {
        int d;
        int node;

        Pair(int d, int node) {
            this.d = d;
            this.node = node;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.d - y.d);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.d;
            int node = curr.node;

            for (Pair neighbor : adj.get(node)) {
                int edgewt = neighbor.d;
                int adjnode = neighbor.node;

                if (d + edgewt < dist[adjnode]) {
                    dist[adjnode] = d + edgewt;
                    pq.add(new Pair(dist[adjnode], adjnode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices ->");
        int V = sc.nextInt();

        System.out.println("Enter the number of edges ->");
        int E = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v w) where u and v are vertices and w -> weight ->");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u)); 
        }

        System.out.println("Enter the source vertex->");
        int S = sc.nextInt();

        int[] result = dijkstra(V, adj, S);

        System.out.println("The shortest distances from source vertex " + S + " are->");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + "-> " + result[i]);
        }

    }
}