package self.leetcode;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] arr) {
        int sum = 0, n=arr.length;

        for(int i=0;i<n;i++) sum += arr[i];

        if(sum%2!=0) return false;

        return subsetSumToK(n, sum/2, arr);
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[] dp = new boolean[k+1];

        dp[0] = true;

        if(arr[0]<=k)
            dp[arr[0]] = true;

        for(int i =1;i<n;i++){
            boolean[] cur = new boolean[k+1];
            cur[0] = true;
            for(int j=1;j<=k;j++){
                boolean notTake = dp[j];

                boolean take = false;
                if(arr[i]<=j)
                    take = dp[j-arr[i]];

                cur[j] = take||notTake;
            }
            dp = cur;
        }
        return dp[k];
    }

    public static void main(String[] args){

    }
}

class Solution {// 0 ms solution
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if ((sum & 1) > 0) {
            return false;
        }
        int target = sum / 2;
        return this.dfs(arr, new boolean[target + 1], 0, target);
    }

    private boolean dfs(int[] arr, boolean[] dp, int index, int target) {
        if (index >= arr.length) {
            return false;
        } else if (arr[index] == target) {
            return true;
        } else {
            int num = target - arr[index];
            if (num > 0 && !dp[num]) {
                dp[num] = true;
                return this.dfs(arr, dp, index + 1, num) || this.dfs(arr, dp, index + 1, target);
            } else {
                return this.dfs(arr, dp, index + 1, target);
            }
        }
    }
}

class AnotherSolution {// memory usage
    public boolean canPartition(int[] arr) {
        int target = 0;
        if (arr == null || arr.length <= 1) return false;
        for (int num: arr) target += num;
        if (target % 2 != 0) return false;
        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: arr) {
            if (num > target) return false;
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}