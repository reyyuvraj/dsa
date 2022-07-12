package sheet.sde.dp;

import java.util.Arrays;
import java.util.HashSet;

public class EqualSubsetSum {

    public boolean canPartition(int[] arr) { // T.C. -> O(len * sum(arr))
        int len = arr.length;

        if (len == 1) return false;

        int sum = 0;
        for (int i : arr)
            sum += i;

        if ((sum & 1) == 1) return false;
        sum /= 2;

        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for (int num : arr) {
            HashSet<Integer> tempSet = new HashSet<>();
            for (Integer j : set) {
                if (j + num == sum)
                    return true;
                tempSet.add(j + num);
            }
            set.addAll(tempSet);
        }

        return false;
    }

    public boolean canPartitionOptimized(int[] nums) {
        int sum = 0;

        for (int num : nums) sum+=num;

        if ((sum & 1) == 1) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums)
            for (int i = sum; i > 0; i--)
                if (i >= num) dp[i] = dp[i] || dp[i-num];
                else break;


        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 11, 5, 5};
        System.out.println(new EqualSubsetSum().canPartitionOptimized(arr));
    }
}
