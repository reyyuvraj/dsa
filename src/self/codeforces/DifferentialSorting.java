package self.codeforces;

import java.util.*;

public class DifferentialSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = in.nextInt();
            if (!differentialSorting(arr))
                System.out.println("-1");
            else {
                if (arr[arr.length - 2] > 0 && arr[arr.length - 1] > 0)
                    differentialSortingPrint(arr);
                else if (arr[arr.length - 2] < 0 && arr[arr.length - 1] > 0)
                    differentialSortingPrint(arr);
                else {
                    if (isSorted(arr))
                        System.out.println("0");
                    else
                        System.out.println("-1");
                }
            }
            t--;
        }
    }

    public static boolean differentialSorting(int[] arr) {
        return arr[arr.length - 1] >= arr[arr.length - 2];
    }

    public static void differentialSortingPrint(int[] arr) {
        System.out.println(arr.length - 2);
        for (int i = 0; i + 2 < arr.length; i++) {
            System.out.println((i + 1) + " " + (arr.length - 1) + " " + (arr.length));
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}