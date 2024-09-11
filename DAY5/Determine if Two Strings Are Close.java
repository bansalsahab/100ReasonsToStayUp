class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 !=len2 ) return false;

        HashSet<Character> set1 =new HashSet<>();
        HashSet<Character> set2 =new HashSet<>();
        for(int i= 0; i<len1; i++){
            char ch1= word1.charAt(i);
            set1.add(ch1);
        }
        for(int i= 0; i<len2; i++){
            char ch2= word2.charAt(i);
            set2.add(ch2);
        }
        
        if(!set1.equals(set2)) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch1 : word1.toCharArray()) freq1[ch1 - 'a']++;
        for (char ch2 : word2.toCharArray()) freq2[ch2 - 'a']++;

        Arrays.sort(freq1);

        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
