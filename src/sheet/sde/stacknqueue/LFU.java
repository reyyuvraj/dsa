package sheet.sde.stacknqueue;


import java.util.*;

public class LFU {

    HashMap<Integer, Integer> inCacheElements;//value of the key stored
    HashMap<Integer, Integer> freq;//count of the key stored
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int min;

    public LFU(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        inCacheElements = new HashMap<>();
        freq = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if (!inCacheElements.containsKey(key))
            return -1;

        int frequency = freq.get(key);
        freq.put(key, frequency + 1);
        lists.get(frequency).remove(key);

        if (!lists.containsKey(frequency + 1))
            lists.put(frequency + 1, new LinkedHashSet<>());
        lists.get(frequency + 1).add(key);

        return inCacheElements.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (inCacheElements.containsKey(key)) {
            inCacheElements.put(key, value);
            get(key);
            return;
        }

        if (inCacheElements.size() >= capacity) {
            int empty = lists.get(min).iterator().next();
            lists.get(min).remove(empty);
            inCacheElements.remove(empty);
        }

        inCacheElements.put(key, value);
        freq.put(key, 1);
        min = 1;
        lists.computeIfAbsent(min, ignore -> new LinkedHashSet<>());
        lists.get(min).add(key);
    }
}
