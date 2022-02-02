package self.codeforces;

import java.util.*;

public class VasyaWrestling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];

        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();

        int sum = 0, size_first=0, size_second=0;
        short last = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > 0) {
                first.add(arr[i]);
                last = 1;
                size_first++;
            } else {
                second.add(arr[i] * -1);
                last = 2;
                size_second++;
            }
            sum += arr[i];
        }

        if (sum != 0) {
            if (sum > 0)
                System.out.println("first");
            else
                System.out.println("second");
        } else {
            int p = 0, q = 0;

            while (p < first.size() && q < second.size()) {
                if (Objects.equals(first.peek(), second.peek())) {
                    p++;
                    q++;
                } else {
                    if (first.peek() > second.peek())
                        System.out.println("first");
                    else
                        System.out.println("second");
                    break;
                }
                first.remove();
                second.remove();
            }

            if (first.isEmpty() && second.isEmpty()) {
                String str = (last == 1) ? "first" : "second";
                System.out.println(str);
            }
        }
    }
}