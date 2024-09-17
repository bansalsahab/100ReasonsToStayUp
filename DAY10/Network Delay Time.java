class Solution {
    public int networkDelayTime(int[][] times, int N, int K) { 
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

 
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));  
        pq.offer(new int[]{K, 0});  
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

         
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

          
            if (time > dist[node]) continue;

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int travelTime = neighbor[1];

                    int newDist = time + travelTime;
                    if (newDist < dist[nextNode]) {
                        dist[nextNode] = newDist;
                        pq.offer(new int[]{nextNode, newDist});
                    }
                }
            }
        }
 
        int maxDist = Arrays.stream(dist).skip(1).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}
