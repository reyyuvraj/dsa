package self.leetcode;

public class ReverseInteger {

    public static int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int rem = x % 10;
            int n = res * 10 + rem;
            if ((n - rem) / 10 != res) {
                return 0;
            }
            res = n;
            x = x / 10;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(reverse(2131564665));
    }
}