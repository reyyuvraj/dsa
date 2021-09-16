package sheet.bit_manipulation;

public class Bit_CountBitsTillN {

    public static int countBits(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 7, b = 0;
        for (int i = 1; i <= n; i++) {
            b += countBits(i);
        }
        System.out.println("Total set bits till " + n + " are " + b);
    }
}