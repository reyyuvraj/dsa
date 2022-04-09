package self.leetcode;

import java.util.*;

public class TopKElements {

    public int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }

        int size = res.size();

        int[] r = new int[size];

        for (int i=0;i<size;i++){
            r[i] = res.get(i);
        }

        return r;
    }

    public static void main(String[] args){
        int[] arr = {1,2};
        int k = 2;

        System.out.println(Arrays.toString(new TopKElements().topKFrequent(arr, k)));
    }
}
