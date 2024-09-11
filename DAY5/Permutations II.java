class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets=new ArrayList<>() ;
        boolean[] used = new boolean[nums.length];
        generatPermute(nums,new ArrayList<>(),subsets,used);
        return subsets;
    }
    void generatPermute(int[] nums,List<Integer> current,List<List<Integer>>subsets ,boolean[] used){
    
    if(current.size()==nums.length){
        subsets.add(new ArrayList<>(current));
        return;
    }
    for(int i=0 ;i<nums.length; i++){
        if (used[i]) continue;

        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
        used[i] = true; 
        current.add(nums[i]);
        generatPermute(nums,current,subsets,used);
        current.remove(current.size()-1);
        used[i] = false;  
    }
    }
}
