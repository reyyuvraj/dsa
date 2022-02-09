package self.codeforces;

import java.util.*;

public class VasyaWrestling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > 0) {
                first.add(arr[i]);
            } else {
                second.add(arr[i] * -1);
            }
            sum += arr[i];
        }

        if (sum != 0) {
            System.out.println((sum > 0) ? "first" : "second");
            return;
        }

        if (first.size() > second.size()) {
            for (int i = 0; i < second.size(); i++) {
                if (first.get(i) > second.get(i)) {
                    System.out.println("first");
                    return;
                } else if (second.get(i) > first.get(i)) {
                    System.out.println("second");
                    return;
                }
            }
            System.out.println("first");
        } else if (second.size() > first.size()) {
            for (int i = 0; i < first.size(); i++) {
                if (first.get(i) > second.get(i)) {
                    System.out.println("first");
                    return;
                } else if (second.get(i) > first.get(i)) {
                    System.out.println("second");
                    return;
                }
            }
            System.out.println("second");
        } else {
            for (int i = 0; i < first.size(); i++) {
                if (first.get(i) > second.get(i)) {
                    System.out.println("first");
                    return;
                } else if (second.get(i) > first.get(i)) {
                    System.out.println("second");
                    return;
                }
            }
            System.out.println((arr[arr.length - 1] > 0) ? "first" : "second");
        }
    }
}