class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];

            while (sum >= target) {
                int length = windowEnd - windowStart + 1;
                minLength = Math.min(minLength, length);
                
                sum -= nums[windowStart];
                windowStart++; 
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
