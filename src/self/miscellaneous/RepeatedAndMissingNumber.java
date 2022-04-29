package self.miscellaneous;

import kotlin.Pair;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RepeatedAndMissingNumber {

    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {
        BigInteger size = BigInteger.valueOf(n);
        BigInteger multiply = size.multiply(size.add(BigInteger.valueOf(1)));
        BigInteger sumOfFirstN = multiply.divide(BigInteger.valueOf(2));
        BigInteger sqrOfFirstN = (multiply.multiply(size.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1)))).divide(BigInteger.valueOf(6));

        BigInteger totSum = BigInteger.valueOf(0), totSqr = BigInteger.valueOf(0);

        for (Integer i : arr) {
            totSum = totSum.add(BigInteger.valueOf(i));
            totSqr = totSqr.add((BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i)));
        }

        BigInteger sumDif = sumOfFirstN.subtract(totSum);
        BigInteger sumSqr = (sqrOfFirstN.subtract(totSqr)).divide(sumDif);

        int num1 = (sumDif.add(sumSqr)).divide(BigInteger.valueOf(2)).intValue();
        int num2 = (BigInteger.valueOf(num1).subtract(sumDif)).intValue();

        return new Pair<>(num1, num2);
    }

    public ArrayList<Integer> repeatedNumber(final List<Integer> arr) {
        long n = arr.size();
        int missing = 0, repeating = 0;
        long sum = (n * (n + 1)) / 2;
        long sqr = (n * (n + 1) * (2 * n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            sum -= (long) arr.get(i);
            sqr -= (long) arr.get(i) * (long) arr.get(i);
        }

        missing = (int) (sum + sum / sqr) / 2;
        repeating = (int) (missing - sum);

        ArrayList<Integer> res = new ArrayList<>();
        res.add(repeating);
        res.add(missing);

        return res;
    }

    public ArrayList<Integer> repeatedNumberCount(final List<Integer> arr) {
        int n = arr.size();
        ArrayList<Integer> res = new ArrayList<>();
        int[] count = new int[n + 1];

        for (Integer integer : arr) {
            count[integer]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0 || count[i] > 1)
                res.add(count[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 4, 5};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int j : ar) {
            arr.add(j);
        }
        System.out.println(missingAndRepeating(arr, arr.size()));
    }
}
