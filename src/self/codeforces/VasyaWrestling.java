package self.codeforces;

import java.util.*;

public class VasyaWrestling {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Long> f = new ArrayList<>();
        ArrayList<Long> s = new ArrayList<>();

        long sum1 = 0, sum2 = 0, last = 0;

        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            if (num > 0) {
                f.add(num);
                sum1 += num;
            } else {
                s.add(num * -1);
                sum2 += (-1 * num);
            }
            if (i == n - 1)
                last = num;
        }

        if (sum1 > sum2)
            System.out.println("first");
        else if (sum2 > sum1)
            System.out.println("second");
        /*else {
            if (f.equals(s)) {
                if (last>0)
                    System.out.println("first");
                else
                    System.out.println("second");
            } else {
                int i = 0, j = 0;
                while (i < f.size() || j < s.size()) {
                    if (f.get(i) > s.get(j)) {
                        System.out.println("first");
                        return;
                    } else if (s.get(j) > f.get(i)) {
                        System.out.println("second");
                        return;
                    }
                    i++;
                    j++;
                }
            }
        }*/ else {
            int i = 0, j = 0;
            while (i < f.size() || j < s.size()) {
                if (f.get(i) > s.get(j)) {
                    System.out.println("first");
                    return;
                } else if (s.get(j) > f.get(i)) {
                    System.out.println("second");
                    return;
                }
                i++;
                j++;
            }
            if (i==f.size() && j==s.size())
                System.out.println((last>0)?"first":"second");
            else if (i < f.size())
                System.out.println("first");
            else
                System.out.println("second");
        }
    }
}