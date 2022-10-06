package college;

import java.text.DecimalFormat;

public class GeometricProgression {

    public static String number(double a2, double a3, int n) {
        String res = "";

        double r = a3 / a2;

        double number = (a2 / r) * Math.pow(r, n - 1);

        number = Math.round(number * Math.pow(10, 3)) / Math.pow(10, 3);

        res = Double.toString(number);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(number(1,2,5));
    }
}
