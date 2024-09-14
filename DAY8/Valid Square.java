class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
         
        int[] distances = new int[6];
        distances[0] = distSquared(p1, p2);
        distances[1] = distSquared(p1, p3);
        distances[2] = distSquared(p1, p4);
        distances[3] = distSquared(p2, p3);
        distances[4] = distSquared(p2, p4);
        distances[5] = distSquared(p3, p4);

        
        Arrays.sort(distances);

    
        return distances[0] > 0 &&              
               distances[0] == distances[1] &&  
               distances[1] == distances[2] &&  
               distances[2] == distances[3] &&
               distances[4] == distances[5] &&  
               distances[4] == 2 * distances[0]; 
    }

    private int distSquared(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
