package sheet.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] ar) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, ar.length, ar, new ArrayList<>(), res, false);

        return res;
    }

    public void helper(int idx,
                       int n,
                       int[] ar,
                       List<Integer> temp,
                       List<List<Integer>> res,
                       boolean pre) {
        if (idx == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        helper(idx + 1, n, ar, temp, res, false);
        if (idx >= 1 && ar[idx] == ar[idx - 1] && !pre) return;
        temp.add(ar[idx]);
        helper(idx+1, n, ar, temp, res, pre);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        int[] ar = {4, 4, 4, 1, 4};
        System.out.println(new SubsetsII().subsetsWithDup(ar));
    }
}
