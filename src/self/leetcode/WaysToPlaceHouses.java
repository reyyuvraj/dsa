package self.leetcode;


public class WaysToPlaceHouses {
    public int countHousePlacements(int n) {
        int fib =  fibonacci(n);

        return fib;
    }

    private int fibonacci(int n) {
        int prev1 = 1, prev2 = 1, curr;
        int m = (int)1e9 + 7;

        for (int i = 0; i < n; i++){
            curr = (prev1 + prev2)%m;
            prev2 = prev1;
            prev1 = curr;
        }

        return (int)((long) prev1 * prev1 %m);
    }

    public static void main(String[] args) {
        System.out.println(new WaysToPlaceHouses().countHousePlacements(1000));
    }
}
