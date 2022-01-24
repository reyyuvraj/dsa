package self.codeforces;

import java.util.*;

public class DownloadMoreRAM {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            for (int i = 0; i < n; i++)
                b[i] = in.nextInt();
            maximumRAM(n, k, a, b);
            t--;
        }
    }

    private static void maximumRAM(int n, int k, int[] a, int[] b) {
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            if (!tm.containsKey(a[i])) {
                tm.put(a[i], new ArrayList<>());
            }
            tm.get(a[i]).add(b[i]);
        }

        int maximum = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> mapEntry : tm.entrySet()) {
            int x = mapEntry.getKey();
            int y = mapEntry.getValue().size();
            if (k >= x) {
                for (int i = 0; i < y; i++) {
                    maximum += mapEntry.getValue().get(i);
                }
            }
            k += maximum;
            maximum = 0;
        }

        System.out.println(k);
    }
}
