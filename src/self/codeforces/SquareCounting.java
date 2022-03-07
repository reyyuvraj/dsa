package self.codeforces;

import java.util.*;

public class SquareCounting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0) {
            int n = in.nextInt();
            long s = in.nextLong();
            System.out.println(squareCounting(n, s));
            t--;
        }
    }

    private static int squareCounting(int n, long s) {
        if (s == 0)
            return 0;

        return 1;
    }

    private static boolean isPrime(int n) {

        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
