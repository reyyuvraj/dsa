package self.codeforces;

import java.util.*;

public class FindMarble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++)
            p[i] = in.nextInt();
        int step=0;
        while (s != t && p[s] != 0)
        {
            int temp = p[s];
            p[s] = 0;
            s = temp;
            step += 1;
        }
        System.out.println(s == t ? step : -1);
    }
}