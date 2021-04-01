package problem381;

import java.util.*;

class RandomizedCollection {
    private Map<Integer, Integer> mp;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        mp = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if(mp.containsKey(val) == true) {
            mp.put(val, mp.get(val) + 1);
        } else {
            mp.put(val, 1);
        }
        return mp.get(val) == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean flag;
        if((flag = mp.containsKey(val)) == true) {
            mp.put(val, mp.get(val) - 1);
            list.remove(list.indexOf(val));
            if (mp.get(val) == 0) {
                mp.remove(val);
            }
        }
        return flag;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */