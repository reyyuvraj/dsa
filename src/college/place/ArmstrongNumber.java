package college.place;

import java.util.*;

public class ArmstrongNumber {

    public static int getDigitCubeSum(int num) {
        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            sum += (int) Math.pow(rem, 3);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        if (num == getDigitCubeSum(num))
            System.out.println("Given number is a armstrong number.");
        else
            System.out.println("Given number is not a armstrong number.");
    }
}
