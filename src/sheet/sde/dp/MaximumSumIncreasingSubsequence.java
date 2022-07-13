package sheet.sde.dp;

public class MaximumSumIncreasingSubsequence {

    public int maxSubsequence(int[] arr) {
        int len = arr.length, max = 0;
        int[] sumArray = new int[len];

        System.arraycopy(arr, 0, sumArray, 0, len);

        for (int i = 1; i < len; i++)
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i] && sumArray[j] + arr[i] > sumArray[i])
                    sumArray[i] = sumArray[j] + arr[i];

        for (int num : sumArray) max = Math.max(num, max);

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(new MaximumSumIncreasingSubsequence().maxSubsequence(arr));
    }
}
