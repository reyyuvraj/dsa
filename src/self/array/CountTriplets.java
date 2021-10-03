package self.array;

import java.util.Arrays;

public class CountTriplets {

    static void triplets(int[] arr, int value) {
        for (int i = 0; i < arr.length-3; i++) {
            if (twoSum(arr, value - arr[i], i).length == 2) {
                System.out.print(arr[i]);
                System.out.println(Arrays.toString(twoSum(arr, value - arr[i], i)));
            }
        }
    }

    static int[] twoSum(int[] arr, int sum, int k) {
        int max = 0, min = arr[k+1], n = arr.length;
        for (int i = k; i < n; i++) {
            if (arr[i] + min - sum == 0) {
                max = arr[i];
                break;
            }
            if (min > arr[i])
                min = arr[i];
        }
        if (max + min == sum)
            return new int[]{min, max};
        else
            return new int[]{0};
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 7};
        triplets(arr, 11);
    }
}