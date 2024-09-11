class Solution {
    
    public String getHappyString(int n, int k) {
        String[] str = {"a" ,"b","c"};
        List<String> happystring=  new ArrayList<>();
        generatesHappy(0,n,"",happystring,str);
        if (k > happystring.size()) return "";
        return happystring.get(k-1);

    }
    void generatesHappy(int start ,int n ,String current,List<String> happystring,String[] str){
        if (current.length() == n) {
            happystring.add(current);
            return;
        }
        
        for(int i= 0;i<str.length ; i++){
            if(current.isEmpty() || current.charAt(current.length() - 1) != str[i].charAt(0) ){
                generatesHappy(i + 1, n, current + str[i], happystring, str);

            }
        }
    }
} 
