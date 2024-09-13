class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;
        
        for (int t : time) {
            int remainder = t % 60;
            
            int complement = (remainder == 0) ? 0 : 60 - remainder;
            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }
            
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}
