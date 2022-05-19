package sheet.sde.binary;

public class NthRootOfNumber {

    private double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans;
    }

    private double solve(int n, int m) {
        double low = 1, high = m, diff = 1e-6;

        while ((high-low)>diff){
            double mid = (high+low)/2.0;
            if (multiply(mid, n)<m)
                low = mid;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args){
        int n = 3, m = 27;
        System.out.println(new NthRootOfNumber().solve(n, m));
    }
}
