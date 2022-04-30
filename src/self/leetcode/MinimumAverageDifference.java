package self.leetcode;

public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] arr) {
        long sum = 0, sumF = 0, sumL = 0, res = -1;
        int n = arr.length, nF = 1, nL = n - nF, index=0;
        for (int j : arr) {
            sum += j;
        }
        if (sum==0 || n==1)
            return 0;
        sumF = arr[0];
        sumL = sum - sumF;
        res = calculateAverage(sumF, sumL, nF, nL);

        for (int i = 1; i < n-1; i++) {
            sumF += arr[i];
            sumL -= arr[i];
            nF += 1;
            nL -= 1;
            long avg = calculateAverage(sumF, sumL, nF, nL);
            if (res > avg) {
                res = avg;
                index = i;
            }
        }

        long avg = sum/n;
        if (res>avg) index=n-1;

        return index;
    }

    public int calculateAverage(long sumF, long sumL, int nF, int nL) {
        return Math.round(Math.abs(( sumF / nF -  sumL / nL)));
    }

    public static void main(String[] args) {
        int[] arr = {4,2,0};
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(arr));
    }
}
