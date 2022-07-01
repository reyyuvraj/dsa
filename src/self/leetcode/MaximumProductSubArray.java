package self.leetcode;

public class MaximumProductSubArray {

    public int maxProduct(int[] arr) {
        int res = arr[0], tempMax = 1, tempMin = 1;

        for (int num : arr) {
            int tMax = num * tempMax;
            int tMin = num * tempMin;
            tempMax = Math.max(tMax, Math.max(tMin, num));
            tempMin = Math.min(tMax, Math.min(tMin, num));

            res = Math.max(tempMax, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4};
        int[] b = {-2, 0, -1};
        int[] c = {-2};
        System.out.println(new MaximumProductSubArray().maxProduct(b));
    }
}
