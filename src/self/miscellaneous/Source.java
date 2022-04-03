package self.miscellaneous;

import java.util.Scanner;

public class Source {

    static final int bits = 32;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t;

        t = in.nextInt();

        while(t>0){
            int n = in.nextInt();

            int[] arr = new int[n];

            for(int i =0;i<n;i++){
                arr[i] = in.nextInt();
            }

            System.out.println(sum(arr, n));
            t--;
        }
    }

    static int sum(int[] arr, int n){
        int ans = 0;

        for(int i=0;i<bits;i++){
            int count = 0;

            for(int j=0;j<n;j++){
                if((arr[j] & (1<<i)) != 0)
                    count++;
            }

            int subset = (1<< count) -1;

            subset = (subset * (1<<i));

            ans += subset;
        }

        return ans;
    }
}
