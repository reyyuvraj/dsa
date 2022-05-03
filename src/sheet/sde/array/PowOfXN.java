package sheet.sde.array;

public class PowOfXN {

    public static double myPow(double x, int n) {
        return Math.pow(x,n);
    }

    public static void main(String[] args){
        double x = 100.0;
        int n = Integer.MAX_VALUE-1;
        System.out.println(myPow(x, n));
    }
}
