
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxLen = 0;
        for(Integer element : set){
            int prevEl = element-1;
            if(!set.contains(prevEl)){
                int len =1;
                int nextEl = element+1;
                while(set.contains(nextEl)){
                    len++;
                    nextEl++;
                }
                maxLen = Math.max(maxLen , len);
            }
        }
        return maxLen;
    }
}
