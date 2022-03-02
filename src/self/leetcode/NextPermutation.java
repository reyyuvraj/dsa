package self.leetcode;

import java.util.Arrays;

public class NextPermutation {


    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void reverse(int[] arr, int left, int right) {

        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }

    }

    public static void findNextPermutation(int[] arr) {

        if (arr.length <= 1)
            return;

        int last = arr.length - 2;

        while (last >= 0) {
            if (arr[last] < arr[last + 1]) {
                break;
            }
            last--;
        }

        if (last >= 0) {

            int nextGreater = arr.length - 1;

            for (int i = arr.length - 1; i > last; i--) {
                if (arr[i] > arr[last]) {
                    nextGreater = i;
                    break;
                }
            }
            swap(arr, nextGreater, last);
        }

        reverse(arr, last + 1, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        findNextPermutation(a);
    }
}