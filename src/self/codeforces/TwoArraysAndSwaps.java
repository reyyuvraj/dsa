package self.codeforces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TwoArraysAndSwaps {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=1;i<=t;i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            Integer[] b = new Integer[n];
            for(int j=0;j<n;j++)
                a[j]=in.nextInt();
            for(int j=0;j<n;j++)
                b[j]=in.nextInt();
            System.out.println(swaps(a, b, n, k));
        }
    }

    private static int swaps(int[] a, Integer[] b, int n, int k){
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        int sum=0;
        for(int i=0;i<k;i++){
            if(a[i]<b[i])
                a[i]=b[i];
        }
        for(int i=0;i<n;i++){
            sum+=a[i];
        }

        return sum;
    }
}
