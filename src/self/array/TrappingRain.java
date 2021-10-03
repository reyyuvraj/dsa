package self.array;

import java.util.Scanner;
import java.util.Stack;

public class TrappingRain {

    static int water(int[] arr, int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            int left = arr[i];
            for (int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);
            int right = arr[i];
            for (int j = i + 1; j < n; j++)
                right = Math.max(right, arr[j]);
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

    static long maxWater(int[] arr, int n) {
        int left = 0;
        int right = n - 1;

        int l_max = 0;
        int r_max = 0;

        long result = 0;

        while (left <= right) {
            if (r_max <= l_max) {
                result += Math.max(0, r_max - arr[right]);
                r_max = Math.max(r_max, arr[right]);
                --right;
            } else {
                result += Math.max(0, l_max - arr[left]);
                l_max = Math.max(l_max, arr[left]);
                ++left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }*/
        int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(water(arr, arr.length));
        System.out.println(maxWater(arr, arr.length));
    }
}