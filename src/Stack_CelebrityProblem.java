import java.util.Stack;

public class Stack_CelebrityProblem {

    static int[][] m = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    static boolean knows(int a, int b) {
        return m[a][b] == 1;
    }

    static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        int c;

        for (int i = 0; i < n; i++)
            st.push(i);

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (knows(a, b))
                st.push(b);
            else
                st.push(a);
        }

        if (st.empty())
            return -1;

        c = st.pop();

        for (int i = 0; i < n; i++)
        {
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1)
            System.out.println("No Celebrity");
        else
            System.out.println("Celebrity ID " + result);
    }
}