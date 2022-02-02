package self.codeforces;

import java.util.*;

public class PaintingPebbles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > max)
                max = arr[i];

            if (arr[i] < min)
                min = arr[i];
        }

        if (max - min > k)
            System.out.println("NO");
        else {
            System.out.println("YES");
            for (int i = 0; i < n; i++)
                colors(arr[i], k);

        }
    }

    private static void colors(int a, int k) {
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((i+1) % k!=0)?(i+1) % k:k;
        }
        Arrays.sort(arr);
        for (int i = 0; i < a; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
