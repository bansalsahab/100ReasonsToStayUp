class Number implements Comparable<Number>{
    int element;
    int freq;
    public Number(int element ,int freq){
        this.element= element;
        this.freq = freq;
    }
    public int compareTo(Number that){
        return that.freq - this.freq;
    }

}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num ,freqMap.getOrDefault(num,0) +1);
        }
        PriorityQueue<Number> pq =new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            Number number = new Number(entry.getKey() , entry.getValue());
            pq.offer(number);
        }
        int res [] =new int[k];
        int index = 0;
        while(index<k){
            Number number  = pq.poll();
            res[index] = number.element;
            index++;
        }
        return res;
    }
}
