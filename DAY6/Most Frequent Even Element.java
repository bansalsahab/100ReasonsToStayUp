class Element implements Comparable<Element> {
    int num;
    int freq;

    public Element(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    public int compareTo(Element that) {
        if (this.freq != that.freq) {
            return that.freq - this.freq;  
        } else {
            return this.num - that.num; 
        }
    }
}
class Solution {
    public int mostFrequentEven(int[] nums) {
          
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {  
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

       
        PriorityQueue<Element> pq = new PriorityQueue<>();

        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Element(entry.getKey(), entry.getValue()));
        }

    
        return pq.isEmpty() ? -1 : pq.poll().num;
    }
}
