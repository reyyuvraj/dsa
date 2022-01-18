package self.codeforces;

import java.util.*;
public class FedorGame {

    public static int countBits(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static int flippedBits(int a, int b) {
        return countBits(a ^ b);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[m+1];
        for (int i=0;i<m+1;i++)
            arr[i] = in.nextInt();
        int friends=0;
        for(int i = 0; i<m; i++)
        {
            if (flippedBits(arr[i],arr[m])<=k)
                friends++;
        }
        System.out.println(friends);
    }
}
