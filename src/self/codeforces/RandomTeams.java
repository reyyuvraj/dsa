package self.codeforces;

import java.util.*;
public class RandomTeams {

    private static long teamsMax(int n, int m){
        n = n-m+1;
        return ((long) n *(n-1))/2;
    }

    //nope
    private static long teamsMin(int n, int m){
        return m * ((long) ((n - m) / m + 1) * ((n - m) / m)) / 2 +
                (long) (int) Math.ceil(((n - m) /
                        (double) (m))) * ((n - m) % m);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(teamsMin(n, m)+" "+teamsMax(n, m));
    }
}
