class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> unique= new ArrayList<>();
        return generatesUnique(0,s,unique,set);

    }
    private int generatesUnique(int start,String s,List<String> unique,HashSet<String> set){
        if (start == s.length()) {
            return unique.size();   
        }
        int maxSplits = 0;

        for(int i= start+1; i<=s.length(); i++){
            String substring = s.substring(start, i);
            if (!set.contains(substring)) {
                set.add(substring); 
                unique.add(substring);  
                // Recurse and continue splitting the rest of the string
                maxSplits = Math.max(maxSplits, generatesUnique(i, s, unique, set));
                set.remove(substring); 
                unique.remove(unique.size() - 1);  
            }
            
        }
        return maxSplits;
    }
}
