package self.codeforces;

import java.util.*;

public class LittlePony {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int id = 0, count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                id = i;
                count++;
            }
        }

        if (arr[n - 1] > arr[0]) {
            id = n - 1;
            count++;
        }

        if (count == 0)
            System.out.println(count);
        else if (count > 1)
            System.out.println("-1");
        else
            System.out.println(n - 1 - id);
    }


}