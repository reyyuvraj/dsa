package self.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        helper(0, arr.length, arr, n, new ArrayList<>(), res, k);

        return res;
    }

    public void helper(int idx,
                       int n,
                       int[] ar,
                       int target,
                       List<Integer> temp,
                       List<List<Integer>> res,
                       int k) {
        if (temp.size()>k) return;

        if (target == 0 && temp.size() == k) {
            res.add(new ArrayList<>(temp));

            return;
        }

        for (int i = idx; i < n; i++) {
            if (ar[i] > target) break;

            temp.add(ar[i]);
            helper(i + 1, n, ar, target - ar[i], temp, res, k);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(new CombinationSumIII().combinationSum3(k, n));
    }
}
