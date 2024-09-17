class Solution {

    class Pair {
        int diff, x, y;
        
        Pair(int diff, int x, int y) {
            this.diff = diff;
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] dirs = {{-1, 0},{0, -1}, {0, 1},{1, 0}};
    private boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.diff));
        
        pq.offer(new Pair(0, 0, 0));
        result[0][0] = 0;
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int diff = curr.diff;
            int x = curr.x;
            int y = curr.y;
        
            if (x == m - 1 && y == n - 1) {
                return diff;
            }
            
            // Explore all directions.
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (isSafe(newX, newY, m, n)) {
                    int newDiff = Math.max(diff, Math.abs(heights[x][y] - heights[newX][newY]));
                    if (result[newX][newY] > newDiff) {
                        result[newX][newY] = newDiff;
                        pq.offer(new Pair(newDiff, newX, newY));
                    }
                }
            }
        }
        
        return result[m - 1][n - 1];
    }
}
