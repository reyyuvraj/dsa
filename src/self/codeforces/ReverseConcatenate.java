package self.codeforces;

import java.util.*;

public class ReverseConcatenate {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            int max = count(s, n, k);
            int res = Math.min(max, k);
            if (res==0)
                System.out.println("1");
            else
                System.out.println(res);
            t--;
        }
    }

    private static int count(String s, int n, int k) {
        int[] arr = new int[26];
        int max = 0;

        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
