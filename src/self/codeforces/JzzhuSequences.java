package self.codeforces;

import java.util.*;

public class JzzhuSequences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long y = in.nextLong();
        long n = in.nextLong();
        long num = 1000000009;
        long[] k = new long[]{x, y, y - x, -x, -y, x - y};
        System.out.println(Arrays.toString(k));
        System.out.println((k[(int) ((n - 1) % 6)] % num + num) % num);
    }
}