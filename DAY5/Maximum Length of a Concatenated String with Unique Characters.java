class Solution {
    public int maxLength(List<String> arr) {
      return backtrack(arr, 0, "");  
    }
    private int backtrack(List<String> arr, int index, String current) {
        if (!isUnique(current)) {
            return 0; 
        }
        int maxLen = current.length();

        for (int i = index; i < arr.size(); i++) {
            maxLen = Math.max(maxLen, backtrack(arr, i + 1, current + arr.get(i)));
        }

        return maxLen;
    }
    private boolean isUnique(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            if (charCount[c - 'a']++ > 0) {
                return false; 
            }
        }
        return true;
    }    
}
