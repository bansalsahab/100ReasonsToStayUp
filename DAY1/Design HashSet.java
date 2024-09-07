class MyHashSet {
    
    private int numBuckets;
    private List<LinkedList<Integer>> buckets;

 
    public MyHashSet() {
        numBuckets = 15000; 
        buckets = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getHashValue(int key) {
        return key % numBuckets;
    }

    public void add(int key) {
        int index = getHashValue(key);
        LinkedList<Integer> bucket = buckets.get(index);

        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    public void remove(int key) {
        int index = getHashValue(key);
        LinkedList<Integer> bucket = buckets.get(index);

        
        bucket.remove((Integer) key); 
    }

    public boolean contains(int key) {
        int index = getHashValue(key);
        LinkedList<Integer> bucket = buckets.get(index);
        return bucket.contains(key);
    }
}

