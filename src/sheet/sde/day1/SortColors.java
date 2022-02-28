package sheet.sde.day1;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] arr) {
        int count0 = 0, count1 = 0;

        for (int j : arr) {
            if (j == 0)
                count0++;
            else if (j == 1)
                count1++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (count0 > i)
                arr[i] = 0;
            else if (count0 + count1 > i)
                arr[i] = 1;
            else
                arr[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
