package self.codeforces;

import java.util.*;

public class SortTheArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int[] cpy = new int[n];

        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            cpy[i] = arr[i];
            if (i != 0) {
                if (start == -1 && arr[i - 1] > arr[i])
                    start = i - 1;
                if (end == -1 && start != -1 && arr[i] > arr[i - 1]) {
                    end = i - 1;
                }
            }
        }

        Arrays.sort(cpy);
        int print = 0;

        if (Arrays.equals(arr, cpy)) {
            System.out.println("yes");
            System.out.println("1 1");
            print += 1;
        }

        if (start != -1 && end == -1)
            end = arr.length - 1;

        if (start != -1)
            Arrays.sort(arr, start, end + 1);

        if (!Arrays.equals(arr, cpy)) {
            System.out.println("no");
        } else if(print==0) {
            System.out.println("yes");
            System.out.println((start + 1) + " " + (end + 1));
        }
    }
}