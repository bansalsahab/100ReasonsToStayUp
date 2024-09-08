class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i =0 ;i < nums.length-1; i++){
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int currentSum = nums[i]+nums[left]+nums[right];

                if(Math.abs(closestSum -target) > Math.abs(currentSum-target)){
                    closestSum = currentSum;
                }

                if(currentSum < target){
        
                    left++;
                }
                else if (currentSum > target){
                    right--;
                }
                else {
                    return currentSum ;
                }
            }
            
        }
        return closestSum ;
    }
}
