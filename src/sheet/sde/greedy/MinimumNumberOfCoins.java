package sheet.sde.greedy;

import java.util.Arrays;

public class MinimumNumberOfCoins {

    public static int findMinimumCoinsOld(int amount) {
        int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int n = coins.length;

        int[] table = new int[amount + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int res = table[i-coins[j]];
                    if (res!=Integer.MAX_VALUE && res+1<table[i])
                        table[i] = res+1;
                }
            }
        }

        if (table[amount] == Integer.MAX_VALUE) return -1;

        return table[amount];
    }

    public static int findMinimumCoins(int amount)
    {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        //1000, 500, 100, 50, 20, 10, 5, 2, 1
        int n = coins.length, j=n-1;
        int count=0;

        for (int i=n-1; i>=0; i--) {
            while(amount>=coins[i]){
                amount-=coins[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int V = 49;
        System.out.println("Minimum coins required is "
                + findMinimumCoins(V));
    }
}
