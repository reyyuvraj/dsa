package self.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 9)));
    }

    private static int[] twoSum(int[] a, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (hm.containsKey(target - a[i]))
                return new int[]{i, hm.get(target - a[i])};
            hm.put(a[i], i);
        }

        return new int[]{-1, -1};
    }
}
