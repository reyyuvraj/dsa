package sheet.sde.greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {

    public static int calculateMinPlatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int trains_at_station = 1, res = 1;
        int i=1, j=0;

        while(i<n && j<n){
            if (at[i]<=dt[j]){
                trains_at_station++;
                i++;
            } else if (at[i]>dt[j]) {
                trains_at_station--;
                j++;
            }

            if (trains_at_station>res)
                res = trains_at_station;
        }
        return res;
    }
}
