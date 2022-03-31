package self.leetcode;

public class MakeArrayAlternating {

    public int minimumOperations(int[] nums) {
        int[][] frequency = new int[100001][2];
        int i = 0, j = 0, k = 0, ans = 0;

        for (i = 0; i < nums.length; i++) {
            frequency[nums[i]][i & 1]++;
        }

        for (i = 1, j = k = 0; i < 100001; i++) {
            ans = Math.max(ans, Math.max(frequency[i][0] + k, frequency[i][1] + j));
            j = Math.max(j, frequency[i][0]);
            k = Math.max(k, frequency[i][1]);
        }

        return nums.length - ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,2,4,3};
        System.out.println(new MakeArrayAlternating().minimumOperations(nums));
    }
}
