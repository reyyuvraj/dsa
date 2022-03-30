package self.leetcode;

import java.util.Arrays;

public class RearrangedSmallestValue {

    public static long smallestNumber(long num) {
        boolean isNegative = false;
        if (num <= 0) {
            num *= -1;
            isNegative = true;
        }
        String str = Long.toString(num);
        char[] ar = str.toCharArray();
        Arrays.sort(ar);

        if (!isNegative) {
            if (ar[0] == '0') {
                for (int i = 1; i < ar.length; i++) {
                    if (ar[i] != '0') {
                        char temp = ar[i];
                        ar[i] = '0';
                        ar[0] = temp;
                        break;
                    }
                }
            }
            str = String.valueOf(ar);
            num = Long.parseLong(str);
        } else {
            str = String.valueOf(ar);

            StringBuffer sbr = new StringBuffer(str);
            sbr.reverse();
            str = sbr.toString();
            num = Long.parseLong(str);
            num *= -1;
        }

        return num;
    }

    public static void main(String[] args) {
        long num = -7605;
        System.out.println(smallestNumber(num));
    }
}
