package self.leetcode;

import  java.util.*;
public class SingleNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0;i<n;i++)
            arr[i] = in.nextInt();

        System.out.println(singleNumber(arr));
    }

    static int singleNumber(int[] nums){
        int ans = 0;
        for (int i : nums) ans ^= i;
        return ans;
    }
}