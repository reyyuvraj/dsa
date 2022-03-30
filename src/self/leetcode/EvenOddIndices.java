package self.leetcode;

import java.util.Arrays;

public class EvenOddIndices {

    public static int[] sortEvenOdd(int[] nums) {
        int n = nums.length, o = n/2, e = n/2;
        if (n % 2 != 0)
            e += 1;
        int[] odd = new int[o];
        int[] eve = new int[e];

        o = 0;
        e = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                eve[e] = nums[i];
                e++;
            } else {
                odd[o] = nums[i];
                o++;
            }
        }

        System.out.println(Arrays.toString(eve)+"\n"+Arrays.toString(odd));

        Arrays.sort(eve);
        Arrays.sort(odd);
        o = odd.length - 1;
        e = 0;

        System.out.println(Arrays.toString(eve)+"\n"+Arrays.toString(odd));

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = eve[e];
                e++;
            } else {
                nums[i] = odd[o];
                o--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sortEvenOdd(arr)));
    }
}
