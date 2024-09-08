public class Solution {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        // max nums value is 100 so two elements sum can be max 200
        int[] m = new int[201];
        for (int i = 1; i < nums.length - 2; i++) {
            for (int j = 0; j < i; j++) {
                // update all possible 2 sums
                m[nums[j] + nums[i]]++;
            }
            for (int j = i + 2; j < nums.length; j++) {
                // fix third element and search for fourth - third in 2 sums as a  + b + c = d == a
                // +  b = d - c
                int diff = nums[j] - nums[i + 1];
                if (diff >= 0) {
                    count += m[diff];
                }
            }
        }
        return count;
    }
}
