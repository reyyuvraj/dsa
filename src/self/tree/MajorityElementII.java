package self.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        int c = n / 3 + 1;

        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int j : arr) {
            if (!hm.containsKey(j))
                hm.put(j, c);
            hm.put(j, hm.get(j) - 1);
            if (hm.get(j) == 0)
                list.add(j);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3};
        System.out.println(new MajorityElementII().majorityElement(arr));
    }
}
