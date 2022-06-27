package self.leetcode;


public class WaysToPlaceHouses {
    public int countHousePlacements(int n) {
        int fib =  fibonacci(n+2);

        return fib;
    }

    private int fibonacci(int n) {
        int[] series = new int[n];

        series[0] = 0;
        series[1] = 1;

        for (int i = 2; i <= n; i++)
            series[i] = (series[i - 1] + series[i - 2]);

        return series[n];
    }

    private int fib(int n) {
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new WaysToPlaceHouses().countHousePlacements(1));
    }
}
