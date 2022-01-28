package self.codeforces;

import java.util.*;
public class FunEven {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++)
                a[i]= in.nextInt();
            System.out.println(funSubArray(a));
            t--;
        }
    }

    private static int funSubArray(int[] a) {
        int operations = 0;
        int k=0;
        for (int i=1;i<a.length;i+=k){
           for (int j=0;j<a.length;j++){

           }
        }
        return 0;
    }
}
