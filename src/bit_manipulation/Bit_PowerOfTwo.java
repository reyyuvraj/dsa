package bit_manipulation;

public class Bit_PowerOfTwo {

    public static boolean powerOfTwo(int n) {
        return (n != 0) && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 8;
        boolean c = powerOfTwo(n);
        String s = c ? "Yes" : "No";
        System.out.println(s);
    }
}