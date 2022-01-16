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

    static int xenia(int n, int m, int[] arr) {
        int res = 0;
        for (int i = 1; i < m; i++) {
            if (arr[i] < arr[i - 1]) res += n + arr[i];
            else if (arr[i] > arr[i - 1]) res += arr[i] - arr[i - 1];
            //System.out.println(i + " " + res);
        }
        return res;
    }
}