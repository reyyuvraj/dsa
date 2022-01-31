package self.codeforces;

import java.util.*;

public class PetyaStaircases {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] dirty = new int[m];
        int[] staircases = new int[n+1];

        for (int i = 0; i < m; i++) {
            dirty[i] = in.nextInt();
            staircases[dirty[i]] = 1;
        }

        if (staircases[1]==1 || staircases[n]==1)
            System.out.println("NO");
        /*else if()*/

    }

    private static boolean climbing(int[] staircases){
        int pre1=0, pre2=0;
        for (int i= staircases.length-1;i>=0;i--){
            int cur = 0;
            if (staircases[i-1]==0)
                cur = i-1;
            else if (staircases[i-2]==0)
                cur = i-2;
            else if (staircases[i-3]==0)
                cur = i-3;
            else
                return false;
        }
        return true;
    }
}
