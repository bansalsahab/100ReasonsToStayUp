class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        boolean mins[] = new boolean[1440];
        for(String time: timePoints){
            int h= Integer.parseInt(time.substring(0,2));
            int m= Integer.parseInt(time.substring(3,5));
            int minutes = h*60 + m;

            if(mins[minutes]) return 0;
            mins[minutes] = true;
        }
        int prev =-1;
        int firstVal = -1;
        int minDiff =Integer.MAX_VALUE;
        for(int curr =0 ; curr<1440 ; curr++){
            if(mins[curr]){
                if(prev == -1){
                    firstVal =curr;
                    prev = curr;
                }
                else{
                    minDiff = Math.min(minDiff ,curr-prev);
                    prev =curr;
                }
            }
        }
        if(prev !=-1){
            minDiff = Math.min(minDiff,1440 + firstVal -prev);
        }
        return minDiff;

    }
}
