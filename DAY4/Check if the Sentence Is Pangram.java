class Solution {
    public boolean checkIfPangram(String sentence) {
        int panagram[] = new int[26];
        for(int i = 0 ; i < sentence.length() ; i++){
            char ch = sentence.charAt(i);
            int character = ch - 'a';
            panagram[character]++;
        }
        for(int num : panagram){
            if(num == 0) return false;
        }
        return true;
    }
}
