package self.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static Integer[] hash(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            Integer d = k - arr[i];
            if (hm.containsKey(d)) {
                return new Integer[]{hm.get(d), i};
            }

            hm.put(arr[i], i);
        }
        return null;
    }

    static void array(int[] arr, int k) {
        int a = 0, b = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 4;
        array(arr, key);
        System.out.println(Arrays.toString(hash(arr, key)));
    }
}
