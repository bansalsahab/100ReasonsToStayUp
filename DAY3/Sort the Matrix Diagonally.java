class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m =mat.length;
        int n =mat[0].length;
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        //store
        for(int i= 0; i<m;i++){
            for(int j =0 ;j <n ;j++){
               int key =i -j;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        //sort
        for(List<Integer> element : map.values()){
            Collections.sort(element);
        }
        //store in matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                mat[i][j] = map.get(key).remove(0);  
            }
        }
        return mat;
    }
}
