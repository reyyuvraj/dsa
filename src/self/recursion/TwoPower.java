package self.recursion;

public class TwoPower {

    static int power(int n) {
        if (n == 0)
            return 1;
        return 2 * power(n - 1);
    }

    static int fastExponentiation(int n) {
        if (n == 0)
            return 1;
        int a = fastExponentiation(n / 2);
        if (n % 2 == 1)
            return 2 * a * a;
        else
            return a * a;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(power(n));
        System.out.print(fastExponentiation(n));
    }
}