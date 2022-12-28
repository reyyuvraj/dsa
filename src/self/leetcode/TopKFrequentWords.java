package self.leetcode;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        TreeMap<Integer, List<String>> freqMap = new TreeMap<>();
        for (String str : map.keySet()) {
            int freq = map.get(str);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(str);
        }

        List<String> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<String>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        return res;
    }
}
