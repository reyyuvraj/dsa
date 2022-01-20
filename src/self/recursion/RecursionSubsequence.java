package self.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionSubsequence {

    private static void subsequence(int index, int[] arr, List<Integer> set){
        if (index>= arr.length){
            System.out.println(set);
            return;
        }

        set.add(arr[index]);

        subsequence(index+1, arr, set);

        set.remove(set.size()-1);

        subsequence(index+1, arr, set);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        List<Integer> set = new ArrayList<>();
        subsequence(0, arr, set);
    }
}
