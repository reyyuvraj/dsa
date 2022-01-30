package self.codeforces;

import java.util.*;

public class RoadsideTrees {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int total_time = arr.length + (arr.length - 1);
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        total_time += arr[0];
        for (int i = 1; i < n; i++) {
            int height = arr[i] - arr[i - 1];
            if (height != 0)
                total_time += Math.abs(height);
        }
        System.out.println(total_time);
    }
}
