package self.codeforces;

import java.util.*;

public class XeniaRingRoad {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(xenia(n, m, arr));
    }

    static long xenia(int n, int m, int[] arr) {
        long res = arr[0] - 1;
        for (int i = 1; i < m; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < 0) res += n - arr[i - 1] + arr[i];
            else if (diff > 0) res += diff;
        }
        return res;
    }
}