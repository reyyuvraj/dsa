package self.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class RepeatedAndMissingNumber {

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

    }
}
