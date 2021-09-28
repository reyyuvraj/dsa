package self.miscellaneous;

public class NumberSum {

    static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    static int numberSum(int n) {
        int a = sumOfDigits(n);
        if (a < 10)
            return a;
        return numberSum(a);
    }

    public static void main(String[] args) {
        int n = 36172;
        System.out.println(numberSum(n));
    }
}