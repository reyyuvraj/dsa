package self.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, output, set, 0, 0);
        return output;
    }

    public static void combinationSum(int[] candidates, int target, List<List<Integer>> output, List<Integer> set, int index, int sum) {

        if (sum > target)
            return;

        if (sum == target) {
            output.add(set);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                List<Integer> list = new ArrayList<>(set);
                list.add(candidates[i]);
                combinationSum(candidates, target-candidates[i], output, list, i, sum);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2};
        System.out.println(combinationSum(candidates, 1));
    }
}
