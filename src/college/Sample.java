package college;

import java.util.Stack;

public class Sample {

    int findRepeatFirstN2(String s)
    {
        int pos = -1, len = s.length(), i, j;

        for (i = 0; i < len; i++)
        {
            for (j = i + 1; j < len; j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    pos = i;
                    break;
                }
            }
            if (pos != -1)
                break;
        }

        return s.charAt(pos);
    }

    private int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
