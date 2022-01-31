package self.codeforces;

import java.util.*;

public class DivisibleSeven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            System.out.println(numberChange(n));
            t--;
        }
    }

    private static int numberChange(int n) {
        int result = n;
        if (n%7==0)
            return n;

        if (numberOfDigits(n)==2)
        {
            int num = n%10;
            switch (num)
            {
                case 0 : result = 70; break;
                case 1 : result = 21; break;
                case 2 : result = 42; break;
                case 3 : result = 63; break;
                case 4 : result = 84; break;
                case 5 : result = 35; break;
                case 6 : result = 56; break;
                case 7 : result = 77; break;
                case 8 : result = 28; break;
                case 9 : result = 49; break;
                default: result = n;
            }
        }

        if (numberOfDigits(n)==3)
        {
            int unit = n%10;
            int tens = (n/10)%10;
            int third = n/100;

            for (int i = 0; i<=9; i++){
                int c1 = third*100+tens*10+i;
                if (c1%7==0){
                    return c1;
                }
                int c2 = third*100+i*10+unit;
                if (c2%7==0)
                    return c2;
                if (i==0)
                    continue;
                int c3 = i*100+tens*10+unit;
                if (c3%7==0)
                    return c3;
            }
        }
        return result;
    }

    private static int numberOfDigits(int n) {
        int count=0;
        while(n>0){
            n = n/10;
            count++;
        }
        return count;
    }
}