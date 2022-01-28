package self.codeforces;

import java.util.*;
public class MinMaxSwap {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i=0;i<n;i++)
                a[i]= in.nextInt();
            for (int i=0;i<n;i++)
                b[i]= in.nextInt();
            System.out.println(swapValue(a, b));
            t--;
        }
    }

    static  int swapValue(int[] a, int[] b){

        int max1=0, max2=0;

        for (int i=0;i<a.length;i++){
            if (a[i]>b[i]){
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            if (a[i]>max1)
                max1=a[i];
            if (b[i]>max2)
                max2=b[i];
        }
        return max1*max2;
    }
}
