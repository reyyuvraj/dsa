package self.array;

import java.util.Arrays;

public class RotateArray {

    static void rotate(int[] arr) {
        int a = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = a;
    }

    static int[] rotateTenTimes(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1)
            return arr;

        int rem = 10 % arr.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (i + rem < n)
                result[i + rem] = arr[i];
            else
                result[rem - i] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(rotateTenTimes(arr)));
    }
}