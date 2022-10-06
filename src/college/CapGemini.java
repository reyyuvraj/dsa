package college;

import java.util.Scanner;

public class CapGemini {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        int count = 0;

        while (t > 0) {
            String s = in.next();
            if (checkString(s))
                count++;
            t--;
        }

        System.out.println(count);
    }

    private static boolean checkString(String str) {
        String s = str;
        str = str.replaceAll("a", "");
        str = str.replaceAll("b", "");

        if (str.length() != 0)
            return false;

        int lastIndexOfA = s.lastIndexOf('a');

        for (int i = 0; i < s.length(); i++) {
            if (i <= lastIndexOfA) {
                if (s.charAt(i) != 'a')
                    return false;
            } else {
                if (s.charAt(i) != 'b')
                    return false;
            }
        }

        return true;
    }
}
