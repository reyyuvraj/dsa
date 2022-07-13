package self.leetcode;

import java.util.ArrayList;

public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        int sum = 0;
        ArrayList<Integer> sticksList = new ArrayList<>();

        for (int i : matchsticks) {
            sum += i;
            sticksList.add(i);
        }

        if ((sum % 4) == 1) return false;

        sum /= 4;
        int count = 4;

        while (count>0){
            if (!isSumPossible(sticksList, sum)) return false;

            count--;
        }

        return true;
    }

    public boolean isSumPossible(ArrayList<Integer> sticksList, int sum) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (Integer num : sticksList)
            for (int i = sum; i > 0; i--)
                if (i >= num) dp[i] = dp[i] || dp[i-num];
                else break;

        return dp[sum];
    }

    private void makeSum(ArrayList<Integer> sticksList, int sum) {

    }
}
