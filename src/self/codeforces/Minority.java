package self.codeforces;

import java.util.*;

public class Minority {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            String str = in.next();
            System.out.println(check(str));
            t--;
        }
    }

    private static int check(String str) {
        String strOne = str.replaceAll("0", "");
        String strZero = str.replaceAll("1", "");

        int lenOne = strOne.length();
        int lenZero = strZero.length();

        if (lenOne > lenZero)
            return lenZero;
        else if (lenZero > lenOne)
            return lenOne;
        else return 0;
    }
}
