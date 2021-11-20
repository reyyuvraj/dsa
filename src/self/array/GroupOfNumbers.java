package self.array;

import java.util.*;

public class GroupOfNumbers {

    static void group_sol(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : arr) {
            if (!hm.containsKey(num)) {
                hm.put(num, 1);
            } else {
                hm.put(num, hm.get(num) + 1);
            }
        }
        int size = hm.size();
        int[] keys = new int[size];
        int[] values = new int[size];
        int index = 0;
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        System.out.println(List.of(hm));
        for (Map.Entry<Integer, Integer> mapEntry : hm.entrySet()) {
            keys[index] = mapEntry.getKey();
            values[index] = mapEntry.getValue();
            if (!tm.containsKey(values[index])) {
                tm.put(values[index], new ArrayList<>());
            }
            tm.get(values[index]).add(keys[index]);
            index++;
        }
        System.out.println(List.of(tm));
        int[] result = new int[values.length];
        int k = values.length-1;
        for (Map.Entry<Integer, ArrayList<Integer>> mapEntry : tm.entrySet()){
            int s=mapEntry.getValue().size();
            for (int i=0;i<s;i++){
                result[k]=mapEntry.getValue().get(i);
                k--;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 6};
        group_sol(arr);
    }
}
