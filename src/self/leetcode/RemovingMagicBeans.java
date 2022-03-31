package self.leetcode;

import java.util.Arrays;

public class RemovingMagicBeans {

    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long min = beans[0];
        beans[0]=0;

        return min;
    }

    public static void main(String[] args){
        int[] arr = {4,1,6,5};
        System.out.println(minimumRemoval(arr));
    }
}
