class Solution {
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);  
        }
        return parent[x];
    }
    private void union(int[] parent, int x, int y){
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY; 
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; 
        }
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i; 
        }

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            union(parent, u, v);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                components++;
            }
        }
        return components - 1;
    }
}
