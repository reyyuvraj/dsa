package self.dynamic;

import java.util.*;
public class FrogJump {

    private static int frogJump(int n,int[] stairs){
        int[] energy = new int[n+1];
        energy[0] = 0;

        for (int i=1; i<n; i++){
            int fs = energy[i-1]+Math.abs(stairs[i]-stairs[i-1]);
            int ss = Integer.MAX_VALUE;

            if (i>1) ss=energy[i-2]+Math.abs(energy[i]-energy[i-1]);

            energy[i]= Math.min(fs, ss);
        }
        return energy[n-1];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t>0){
            int n = in.nextInt();
            int[] stairs = new int[n];
            for (int i=0; i<n; i++)
                stairs[i]= in.nextInt();
            System.out.println(frogJump(n, stairs));
            t--;
        }
    }
}
