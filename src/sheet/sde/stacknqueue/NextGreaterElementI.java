package sheet.sde.stacknqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] a, int[] b) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : b) {
            while (!st.isEmpty() && st.peek() < n)
                map.put(st.pop(), n);
            st.push(n);
        }

        for (int i = 0; i < a.length; i++)
            a[i] = map.getOrDefault(a[i], -1);

        return a;
    }
}
