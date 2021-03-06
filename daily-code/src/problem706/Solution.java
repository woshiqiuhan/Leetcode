package problem706;


import java.util.HashMap;
import java.util.Map;

class MyHashMap {

    private final Map<Integer, Integer> mp;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        mp = new HashMap<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        mp.put(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return mp.getOrDefault(key, -1);
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        mp.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */