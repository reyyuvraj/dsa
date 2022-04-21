package self.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] arr) {
        if (arr.length<=1)
            return arr;

        Arrays.sort(arr, Comparator.comparingInt(i -> i[0]));

        List<int[]> res = new ArrayList<>();
        int[] newInterval = arr[0];
        res.add(newInterval);

        for (int[] i: arr){
            if (i[0]<=newInterval[1])
                newInterval[1] = Math.max(newInterval[1], i[1]);
            else{
                newInterval = i;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args){
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(arr)));
    }
}
