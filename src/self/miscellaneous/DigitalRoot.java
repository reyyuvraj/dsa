package self.miscellaneous;

import java.util.Scanner;

public class DigitalRoot {

    static void digital(int k, int d) {
        if (k > 1 && d == 0)
            System.out.println("No solution");
        else {
            System.out.print(d);
            for (int i = 1; i < k; i++)
                System.out.print("0");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int d = in.nextInt();
        digital(k, d);
    }
}