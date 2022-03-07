package self.miscellaneous;

import java.util.*;

public class BeautyOfANumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(nCr(134, 6));
        System.out.println(count(n));
    }

    private static long count(int n) {
        long count = 0, count7 = 0, count8 = 0, count9 = 0;

        if (n == 7)
            return 0;

        for (int i = 1; i <= n; i++) {
            int temp = countBits(i);
            if (temp == 7)
                count7++;
            if (temp == 8)
                count8++;
            if (temp == 9)
                count9++;
        }

        System.out.println(count7 + " " + count8 + " " + count9);

        long f8 = count8 * nCr(count7, 6) * fact(6);
        long f9 = count9 * nCr(count7 + count8, 6) * fact(6);

        count = mod(String.valueOf(f8 + f9), 1000000007);

        return count;
    }

    private static int countBits(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    private static long nCr(long n, long r) {
        return fact(n) / ((fact(r) *
                fact(n - r)));
    }

    private static long fact(long n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    private static long mod(String num, long a) {

        long res = 0;

        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int) num.charAt(i) - '0') % a;

        return res;
    }
}
