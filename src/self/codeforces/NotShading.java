package self.codeforces;

import java.util.*;
public class NotShading {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            boolean black = false;
            String[] arr = new String[n];
            for (int i = 0; i<n;i++)
            {

                arr[i] = in.next();
                if (arr[i].contains("B"))
                    black = true;
            }
            System.out.println(notShading(n,m,r,c,arr, black));
            t--;
        }
    }

    static int notShading(int n, int m, int r, int c, String[] arr, boolean black)
    {
        char ch = arr[r-1].charAt(c-1);
        if (ch=='B')
            return 0;
        else if(ch=='W' && black)
        {
            for (int i=0; i<n; i++)
            {
                if (arr[i].charAt(c-1)=='B')
                    return 1;
            }
            for (int i=0; i<m;i++)
            {
                if (arr[r-1].charAt(i)=='B')
                    return 1;
            }
            return 2;
        }
        else
            return -1;
    }
}
