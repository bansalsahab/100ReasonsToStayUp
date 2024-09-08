class Solution {
    public boolean increasingTriplet(int[] nums) {
        int  n = nums.length;
        if(n<3) return false;
        int num1= Integer.MAX_VALUE;
        int num2= Integer.MAX_VALUE;
        for(int i = 0 ;i < n;i++){
            int num3= nums[i];
            if(num3<=num1){
                num1 = num3;
            }
            else if(num3<=num2){
                num2 = num3;
            }
            else return true;
        }
        return false;
    }
}
