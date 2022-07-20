package self.linkedlist;

public class ReplaceWithPerfectSquare {

    void nearestPerfectSquare(int[] arr, int N) {

        for (int i = 0; i < N; i++) {

            int sqrt = (int) Math.sqrt(arr[i]);

            if (!((sqrt & 1) == (arr[i] & 1)))
                sqrt++;

            System.out.print((sqrt * sqrt) + " ");
        }
    }

    void nearestPerfectSquareTry(int[] arr, int N) {

        for (int i = 1; i <= N; i++) {

            int sqrt = (int) Math.sqrt(arr[i - 1]);
            int low = sqrt - 1;
            int high = sqrt + 1;
            int lowSq = low * low;
            int highSq = high * high;
            int res = 0;

            if (i % 2 == 0) res = (lowSq % 2 == 0) ? lowSq : highSq;
            else res = (lowSq % 2 != 0) ? lowSq : highSq;

            System.out.print(res + " ");
        }
    }

    void getClosestPerfectSquare(int N) {
        int x = (int) Math.sqrt(N);

        //Checking if N is a perfect square
        if ((x * x) == N) {
            System.out.println(N);
            return;
        }

        int aboveN = (x + 1) * (x + 1), belowN = x * x;

        // Variables to store the differences
        int diff1 = aboveN - N;
        int diff2 = N - belowN;

        if (diff1 > diff2)
            System.out.println(belowN + " " + diff2);
        else
            System.out.println(aboveN + " " + diff1);

    }

    public void nextPerfectSquare(int num) {
        // Calculate square root of given number
        int nextSqrt = (int) Math.floor(Math.sqrt(num));
        // Next perfect sqrt
        nextSqrt = nextSqrt + 1;
        // Display given number
        System.out.print("\n Given number : " + num);
        // Display next perfect sqrt
        System.out.print("\n Next Perfect Square (" + nextSqrt + "²) : "
                + (nextSqrt * nextSqrt));
    }

    void nearestPerfectSquareOrigin(int arr[], int N) {

        // Traverse the array
        for (int i = 0; i < N; i++) {

            // Calculate square root of
            // current array element
            int sr = (int) Math.sqrt(arr[i]);

            // If both are of same parity
            if ((sr & 1) == (arr[i] & 1))
                System.out.print((sr * sr) + " ");

                // Otherwise
            else {
                sr++;
                System.out.print((sr * sr) + " ");
            }
        }
    }
}
