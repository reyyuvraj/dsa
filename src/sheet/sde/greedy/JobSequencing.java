package sheet.sde.greedy;

import java.util.Arrays;

public class JobSequencing {


    public static int[] jobScheduling(int[][] arr) {
        Arrays.sort(arr, (a, b) -> (b[2] - a[2]));
        int max = 0, n = arr.length;

        for (int[] job : arr) {
            if (job[1] > max)
                max = job[1];
        }

        int[] res = new int[max + 1];
        Arrays.fill(res, -1);

        int jobCount = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i][1]; j > 0; j--) {
                if (res[j] == -1) {
                    res[j] = i;
                    jobCount++;
                    jobProfit += arr[i][2];
                    break;
                }
            }
        }

        return new int[]{jobCount, jobProfit};
    }

    /*int[] JobSchedulingGfg(Job arr[], int n)
    {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int max = 0;

        for (int i=0;i<n;i++) {
            if (arr[i].deadline > max)
                max = arr[1].deadline;
        }

        int[] res = new int[max + 1];
        Arrays.fill(res, -1);

        int jobCount=0, jobProfit = 0;

        for (int i=0;i<n;i++) {
            for (int j = arr[i].deadline; j > 0 ; j--) {
                if (res[j] == -1) {
                    res[j] = i;
                    jobCount++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{jobCount, jobProfit};
    }*/

    public static void main(String[] args) {
        int[][] jobs = {{1, 4, 20}, {2, 1, 10}, {3, 2, 40}, {4, 2, 30}};
        System.out.println(Arrays.toString(jobScheduling(jobs)));
    }
}
