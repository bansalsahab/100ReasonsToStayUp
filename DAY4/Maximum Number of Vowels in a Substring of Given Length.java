class Solution {
    public int maxVowels(String s, int k) {
        int windowstart =0 ;
        int windowEnd =0 ;
        int n =  s.length();
        int count =0 ;
        int maxCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        maxCount = Math.max(count, maxCount);
        for(windowEnd = k;windowEnd<n;windowEnd++){
            if (isVowel(s.charAt(windowEnd))) {
                count++;
            }
            if (isVowel(s.charAt(windowstart))) {
                count--;
            }
            windowstart++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
