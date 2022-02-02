package self.codeforces;

import java.util.*;

public class PetyaStaircases {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] dirty = new int[m];

        for (int i = 0; i < m; i++) {
            dirty[i] = in.nextInt();
        }

        Arrays.sort(dirty);

        for (int i=0; i<m-2;i++){

        }

    }

    /*private static boolean checkClimbing(int[] dirty){

    }*/

    private static boolean climbing(int[] staircases) {
        for (int i = staircases.length - 1; i >= 4; i--) {
            int cur = 0;
            if (staircases[i - 1] == 0)
                cur = i - 1;
            else if (staircases[i - 2] == 0)
                cur = i - 2;
            else if (staircases[i - 3] == 0)
                cur = i - 3;
            else
                return false;
        }
        return true;
    }
}
