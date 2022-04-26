package self.leetcode;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 2, 4};
        System.out.println(duplicateNumber(arr));
    }

    private static int duplicateNumber(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            num = Math.abs(num);
            if (num < n) {
                if (arr[num] > 0) arr[num] = -arr[num];
                else return num;
            }
        }

        return -1;
    }

    private static int get(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            res ^= i;
        }

        return res;
    }
}
