package self.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//All Divisions With the Highest Score of a Binary Array
public class BinaryArray {

    public static List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length, max = 0;
        int[] zer = new int[n];
        int[] one = new int[n];
        int[] res = new int[n + 1];
        if (nums[0] == 1)
            one[0] = 1;
        else
            zer[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                zer[i] = zer[i - 1] + 1;
                one[i] = one[i - 1];
            }
            if (nums[i] == 1) {
                one[i] = one[i - 1] + 1;
                zer[i] = zer[i - 1];
            }
        }
        res[0] = one[n - 1];
        max = Math.max(res[0], max);
        for (int i = 0; i < n; i++) {
            res[i + 1] = (zer[i]) + (one[n - 1] - one[i]);
            max = Math.max(res[i + 1], max);
        }

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (res[i] == max)
                out.add(i);
        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,0};
        System.out.println(maxScoreIndices(arr));
        // when standing at index "1" is not counted.
    }
}
