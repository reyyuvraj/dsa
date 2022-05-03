package sheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] ar) {
        List<Integer> temp = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(0, ar.length, ar, temp, set, res);

        return res;
    }

    public void helper(int idx, int n,
                       int[] ar,
                       List<Integer> temp,
                       HashSet<String> set,
                       List<List<Integer>> res) {
        if (idx == n) {
            Collections.sort(temp);
            if (!set.contains(temp.toString())) {
                set.add(temp.toString());
                res.add(new ArrayList<>(temp));
            }

            return;
        }
        temp.add(ar[idx]);
        helper(idx + 1, n, ar, temp, set, res);
        temp.remove(temp.size() - 1);
        helper(idx + 1, n, ar, temp, set, res);
    }

    public static void main(String[] args) {
        int[] ar = {4,4,4,1,4};
        System.out.println(new SubsetsII().subsetsWithDup(ar));
    }
}
//Input
//[4,4,4,1,4]
//Expected
//[[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
