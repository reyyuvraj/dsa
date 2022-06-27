package self.leetcode;

import java.util.*;

public class TopKElements {

    public int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        int size = res.size();

        int[] r = new int[size];

        for (int i = 0; i < size; i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    public int[] topKFrequentMinHeap(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : map.keySet()) {
            minHeap.add(i);
            if (minHeap.size() > k)
                minHeap.remove();
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(new TopKElements().topKFrequentMinHeap(arr, k)));
    }
}
