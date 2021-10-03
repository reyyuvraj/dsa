package self.miscellaneous;

import java.sql.SQLSyntaxErrorException;

//import java.util.Scanner;
public class BestTimeForStock {

    static int maxProfit(int[] prices) {
        if (prices.length<2)
            return prices[0];
        else {
            int max = prices[1] - prices[0], min = prices[0], n = prices.length;
            for (int i = 1; i < n; i++) {
                if (prices[i] - min > max)
                    max = prices[i] - min;
                if (min > prices[i])
                    min = prices[i];
            }
            return Math.max(max, 0);
        }

    }

    static void max(int[] arr, int sum) {
        int max = arr[1]-arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min == sum)
                max = arr[i] - min;
        }
        System.out.print(min+" "+max);
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.print(maxProfit(arr));
    }
}