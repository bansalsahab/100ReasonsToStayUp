class Solution {
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder result = new StringBuilder();

        int[] counts = {a, b, c}; //store the remaing count
        char[] chars = {'a', 'b', 'c'};

        while(true){
            int maxIndex = getMaxIndex(counts);
            if (counts[maxIndex] == 0) {
                break; 
            }
            int len =  result.length();
            if(len >=2 && result.charAt(len-1) == chars[maxIndex] && result.charAt(len-2) == chars[maxIndex]){
                int secondMaxIdx = getSecondMaxIndex(counts, maxIndex);
                if (counts[secondMaxIdx] == 0) {
                    break;  // No other characters to use
                }
                result.append(chars[secondMaxIdx]);
                counts[secondMaxIdx]--;
            }else{
                result.append(chars[maxIndex]);
                counts[maxIndex]--;
            }
        }
        return result.toString();

    }
    private int getMaxIndex(int[] counts) {
        if (counts[0] >= counts[1] && counts[0] >= counts[2]) {
            return 0;
        } else if (counts[1] >= counts[0] && counts[1] >= counts[2]) {
            return 1;
        } else {
            return 2;
        }
    }
    private int getSecondMaxIndex(int[] counts, int maxIdx) {
        if (maxIdx == 0) {
            return counts[1] >= counts[2] ? 1 : 2;
        } else if (maxIdx == 1) {
            return counts[0] >= counts[2] ? 0 : 2;
        } else {
            return counts[0] >= counts[1] ? 0 : 1;
        }
    }

}
