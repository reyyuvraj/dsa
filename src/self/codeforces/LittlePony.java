package self.codeforces;

import java.util.*;

public class LittlePony {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arraySortedOrNot(arr, arr.length))
                break;
            if (arr[arr.length-1]<arr[0])
                changeArray(arr, arr.length);
            else
                break;
            count++;
        }

        if (arraySortedOrNot(arr, arr.length))
            System.out.println(count);
        else
            System.out.println("-1");
    }

    static boolean arraySortedOrNot(int[] a, int n) {
        if (n == 1 || n == 0)
            return true;

        return a[n - 1] >= a[n - 2]
                && arraySortedOrNot(a, n - 1);
    }

    static void changeArray(int[] a, int n) {
        int temp = a[a.length - 1];
        for (int i = n - 1; i > 0; i--)
            a[i] = a[i - 1];
        a[0] = temp;
    }
}