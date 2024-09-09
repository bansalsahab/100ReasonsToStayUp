class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n =mat.length;
        int m = mat[0].length;
        int result [] =new int [m * n];

        HashMap<Integer,List<Integer>>map = new HashMap<>();
        //store
        for(int i =0 ; i<n;i++){
            for(int j= 0; j< m;j++){
                int key =i +j;
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);

            }
        } 
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);  //sort the keys

         
        int i =0 ;
        boolean flip =true; 
        for (int key : keys) {
            List<Integer> diagonal = map.get(key); 
            if(flip){
                Collections.reverse(diagonal);
            }
            for(int num : diagonal){
                result[i++] =num ;
            }
            flip = !flip;
        }
        return result;
    }
}
