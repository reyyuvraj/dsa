package self.leetcode;

import java.util.*;
public class ClimbingStairs {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(totalWaysRecursion(n));
        System.out.println(totalWaysOptimized(n));
    }

    static int totalWaysRecursion(int n){
        if (n==0 || n==1) return 1;
        return totalWaysRecursion(n-1)+totalWaysRecursion(n-2);
    }

    static int totalWaysOptimized(int n){
        if (n==0 || n==1) return 1;
        int curr = 0, pre1 = 1, pre2 = 1;

        for (int i=2;i<n+1;i++){
            curr = pre1+pre2;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}
