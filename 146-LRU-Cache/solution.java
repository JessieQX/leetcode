public class LRUCache {
    private int capacity;
    Map<Integer, Integer> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey()) {
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.size() < capacity) {
            if (!map.containsKey()) {
                map.put(key, value);
            }
        }
    }
}