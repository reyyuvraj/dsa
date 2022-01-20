package self.codeforces;

import java.text.DecimalFormat;
import java.util.*;
public class VanyaLanterns {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int l = in.nextInt();

        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[n+1] = l;

        for (int i=1;i<n+1;i++)
            arr[i] = in.nextInt();

        Arrays.sort(arr);

        double max=0;
        double start = (arr[1]!=arr[0])?arr[1]:0;
        double end = (arr[n+1]!=arr[n])?arr[n+1]-arr[n] : 0;
        max = Math.max(start, end);
        for (int i=1;i<n+2;i++){
            double diff = arr[i]-arr[i-1];
            if (diff/2>max) max=diff/2;
        }

        DecimalFormat df = new DecimalFormat("#.0000000000");

        System.out.println(df.format(max));
    }
}
