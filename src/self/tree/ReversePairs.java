package self.tree;

public class ReversePairs {

    public int reversePairs(int[] arr) {
        int count = 0, n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > 2 * arr[j]) count++;
            }
        }

        return count;
    }

    public int reversePairsOptimized(int[] arr, int l, int r) {
        if (l >= r) return 0;

        int m = l + ((r - l) >> 1);
        int res = reversePairsOptimized(arr, l, m) + reversePairsOptimized(arr, m + 1, r);

        int i = l, j = m + 1, k = 0, p = m + 1;
        int[] merge = new int[r - l + 1];

        while (i <= m) {
            while (p <= r && arr[i] > 2L * arr[p]) p++;
            res += p - (m + 1);

            while (j <= r && arr[i] >= arr[j]) merge[k++] = arr[j++];
            merge[k++] = arr[i++];
        }

        while (j <= r) merge[k++] = arr[j++];

        System.arraycopy(merge, 0, arr, l, merge.length);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};//[2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
        System.out.println(new ReversePairs().reversePairs(arr));
        System.out.println(new ReversePairs().reversePairsOptimized(arr, 0, arr.length - 1));
    }
}
