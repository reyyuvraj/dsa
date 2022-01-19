package sheet.bit_manipulation;

public class Bit_FlippedBits {

    public static int countBits(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static int flippedBits(int a, int b) {
        return countBits(a ^ b);
    }

    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(flippedBits(a, b));
        System.out.println(countBits(a));
    }
}
