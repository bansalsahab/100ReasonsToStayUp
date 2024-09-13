class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        long count = 0;
        
        for (int t : hours) {
            int remainder = t % 24;
            
            int complement = (remainder == 0) ? 0 : 24 - remainder;
            if (remainderCount.containsKey(complement)) {
                count += remainderCount.get(complement);
            }
            
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}

