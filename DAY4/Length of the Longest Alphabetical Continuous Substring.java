class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int finalans = 1;
        for(int i = 1; i<s.length();i++){
            char ch1 =s.charAt(i-1);
            char ch2 =s.charAt(i);
            if((ch2 - ch1) == 1){
                ans++;
            }else{
                ans =1;
            }
            finalans = Math.max(ans ,finalans);
            
        }
        return finalans;
    }
}
