package college;

public class SmallestPrimeNumber {

    public int findSumOfPrimes(int[] input1, int input2) {
        boolean hasPrime = false;
        int smallestPrime = Integer.MAX_VALUE, sumPrime = 0;
        int smallestNumber = Integer.MAX_VALUE, sumNumbers = 0;

        for (int i : input1) {
            if (isPrime(i)) {
                hasPrime = true;
                smallestPrime = Math.min(smallestPrime, i);
                sumPrime += i;
                continue;
            }
            smallestNumber = Math.min(smallestNumber, i);
            sumNumbers += i;
        }

        if (hasPrime) return (sumPrime - smallestPrime);
        return (sumNumbers - smallestNumber);
    }

    private boolean isPrime(int n) {
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

    public static void main(String[] args) {
        int[] a = {10, 41, 18, 50, 43, 31, 29, 25, 59, 96, 67};
        int[] b = {10, 20, 30, 40};
        int[] c = {2};
        System.out.println(new SmallestPrimeNumber().findSumOfPrimes(c, 1));
    }
}
