package self.codeforces;

import java.util.*;

public class SortTheArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        int start = -1;
        int end = -1;

        arr[0] = in.nextInt();
        for (int i = 1; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i - 1] > arr[i] && start == -1)
                start = i;
            if (start != -1 && (arr[i] > arr[i - 1] || i==n-1))
                end = i+1;
        }

        System.out.println(start + " " + end);
    }
}
