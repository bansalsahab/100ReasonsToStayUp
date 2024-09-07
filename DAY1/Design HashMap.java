class MyHashMap {
    private final int size = 10000;
    private List<Pair>[] bucket;

    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        bucket = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    
    public void put(int key, int value) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];

        for (Pair pair : chain) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        chain.add(new Pair(key, value));
    }

    public int get(int key) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];

        for (Pair pair : chain) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int bucketNo = key % size;
        List<Pair> chain = bucket[bucketNo];

        for (Pair pair : chain) {
            if (pair.key == key) {
                chain.remove(pair);
                return;
            }
        }
    }
}
