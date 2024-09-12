class Element implements Comparable<Element>{
    String str;
    int freq;
    public Element(String str ,int freq){
        this.str= str;
        this.freq = freq;
    }
    public int compareTo(Element that){
        if (this.freq != that.freq) {
            return that.freq - this.freq; // Min-heap based on frequency
        }
        // If frequencies are the same, compare lexicographically (opposite for max-heap behavior)
        return this.str.compareTo(that.str);
    }

}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();

        for(String str : words){
            freqMap.put(str ,freqMap.getOrDefault(str,0) +1);
        }
        PriorityQueue<Element> pq =new PriorityQueue<>();
        for(Map.Entry<String, Integer> entry : freqMap.entrySet()){
            Element element =  new Element(entry.getKey() , entry.getValue());
            pq.offer(element);
        }
        List<String> ansString = new ArrayList<>();
        int index= 0;
        while(index <k){
            Element element = pq.poll();
            ansString.add(element.str);
            index++;
        }
        return ansString;
    }
}
