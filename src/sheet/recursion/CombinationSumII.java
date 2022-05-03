package sheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, arr.length, arr, target, new ArrayList<>(), res);

        return res;
    }

    public void helper(int idx,
                       int n,
                       int[] ar,
                       int target,
                       List<Integer> temp,
                       List<List<Integer>> res) {
        if (target==0) {
            res.add(new ArrayList<>(temp));

            return;
        }
        for (int i=idx;i<n;i++){
            if (i>idx && ar[i]==ar[i-1]) continue;
            if (ar[i]>target) break;

            temp.add(ar[i]);
            helper(i + 1, n, ar, target-ar[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Arrays.sort(arr);
        System.out.println(new CombinationSumII().combinationSum2(arr, target));
    }
}
