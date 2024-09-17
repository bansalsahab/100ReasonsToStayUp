class Graph {
    int[][] adj;
    int N;

    public Graph(int n, int[][] edges) {
        N = n;
        adj = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], (int)1e9);
            adj[i][i] = 0;
        }

        for (int[] vec : edges) {
            int u = vec[0];
            int v = vec[1];
            int cost = vec[2];

            adj[u][v] = cost;
        }

        //  Warshall
        for (int k = 0; k <n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adj[i][j] = Math.min(adj[i][j], adj[i][u] + cost + adj[v][j]);
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return adj[node1][node2] == (int)1e9 ? -1 : adj[node1][node2];
    }
}
