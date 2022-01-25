package self.codeforces;

import java.util.*;

public class DZYLovesStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        int[] w = new int[26];
        int max = 0;
        for (int i = 0; i < w.length; i++) {
            w[i] = in.nextInt();
            if (w[i] > max)
                max = w[i];
        }

        int value = 0;

        for (int i = 0; i < s.length(); i++) {
            value += w[(int) s.charAt(i) - 'a'] * (i + 1);

        }

        for (int i = s.length() + 1; i < s.length() + k + 1; i++) {
            value += max * i;
        }

        System.out.println(value);

    }
}
