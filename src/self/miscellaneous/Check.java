package self.miscellaneous;

import java.util.HashMap;
import java.util.TreeMap;

public class Check {

    private static int func() {
        try {
            int a = 10, b = 0;
            int c = a / b;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(func());
    }
}


class TimeMap {

    HashMap<String, TreeMap<Integer, String>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key))
            hm.put(key, new TreeMap<>());
        hm.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treeMap = hm.get(key);
        if(treeMap==null) {
            return "";
        }
        Integer floor = treeMap.floorKey(timestamp);
        if(floor==null) {
            return "";
        }
        return treeMap.get(floor);
    }
}