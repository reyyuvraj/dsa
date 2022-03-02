package self.codeforces;

import java.util.*;

public class ChatOnline {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int p = in.nextInt();
        int q = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();

        int[][] a = new int[p][2];
        int[][] c = new int[q][2];

        for (int i = 0; i < p; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        for (int i = 0; i < q; i++) {
            c[i][0] = in.nextInt();
            c[i][1] = in.nextInt();
        }

        int count = 0;

        for (int i = l; i <= r; i++) {
            for (int j = 0; j < q; j++) {
                boolean flag = false;
                int val1 = c[j][0] + i, val2 = c[j][1] + i;
                for (int k = 0;k<p;k++){
                    if (val1>a[k][1] || val2<a[k][0]){
                        continue;
                    }
                    else{
                        count++;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
        }
        System.out.println(count);
    }
}