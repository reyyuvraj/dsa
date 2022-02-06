package college;

import java.util.*;

public class GetPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        List<Integer> ls = new ArrayList<>();
        int[] out = {0};
        subsequence(0, str, ls, out);
        System.out.println(out[0]);
    }

    private static void subsequence(int index, String str, List<Integer> set, int[] out) {
        if (index >= str.length()) {
            return;
        }

        set.add((int) str.charAt(index) - '0');
        int num = getNumber(set);
        if (isPrime(num) && num > out[0])
            out[0] = num;

        subsequence(index + 1, str, set, out);

        set.remove(set.size() - 1);
        num = getNumber(set);
        if (isPrime(num) && num > out[0])
            out[0] = num;

        subsequence(index + 1, str, set, out);
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

    private static int getNumber(List<Integer> set) {
        int num = 0;

        for (int i = 0; i < set.size(); i++) {
            num += (int) (set.get(i) * Math.pow(10, set.size() - i - 1));
        }

        return num;
    }
}
