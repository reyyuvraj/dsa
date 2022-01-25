package self.codeforces;

import java.util.*;

public class TPrimes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        boolean[] primes = new boolean[1000000];

        for (int i=0;i< primes.length;i++){
            primes[i] = isPrime(i);
        }

        while (t > 0) {
            long n = in.nextLong();

            double num = Math.sqrt(n);

            if (num%1==0 && primes[(int) num])
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
    }

    static boolean isPrime(int n) {

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