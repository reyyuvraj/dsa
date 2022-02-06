package college;

import java.util.*;

public class GetOutArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] array = s.split(",");
        int[] arr = new int[array.length];
        int[] positive = new int[array.length];
        int[] negative = new int[array.length];

        int i = 0, j = 0, k = 0, p = 0, n = 0;

        while (i < array.length) {
            int num = getNumber(array[i]);

            if (num >= 0) {
                positive[j] = num;
                p++;
                j++;
            } else {
                negative[k] = num;
                n++;
                k++;
            }

            i++;
        }

        for (i = 0; i < arr.length; i++) {
            if (i < n)
                arr[i] = negative[i];
            else
                arr[i] = positive[i];
        }

        System.out.println(Arrays.toString(negative));
        System.out.println(Arrays.toString(positive));
        System.out.println(Arrays.toString(arr));

    }

    private static int getNumber(String str) {
        int length = str.length(), num = 0;
        boolean negative = false;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '-') {
                negative = true;
                continue;
            }
            num += (str.charAt(i) - '0') * length - i - 1;
        }

        return (negative) ? num * -1 : num;
    }
}
