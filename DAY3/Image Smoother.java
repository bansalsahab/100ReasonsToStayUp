class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m =img[0].length;
        int result [][] = new int [n][m];
        
        for(int i =0 ;i<n ;i++){
            for(int j = 0 ; j< m ;j++){
                int sum = 0;
                int count = 0;
                for (int ni = i - 1; ni <= i + 1; ni++) {
                    for (int nj = j - 1; nj <= j + 1; nj++) {
                        // Check if the neighboring indices are within bounds
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            sum += img[ni][nj];
                            count++;
                        }
                    }
                }
                result[i][j] =sum/count;
                
            }
        }
        return result;
    }
}
