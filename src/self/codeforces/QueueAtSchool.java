package self.codeforces;

import java.util.*;
public class QueueAtSchool {

    public static void main(String[] args){
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        String str = in.next();
        while(t>0)
        {
            str = changeQueue(str, n);
            t--;
        }
        System.out.println(str);
    }

    public static String changeQueue(String str, int n){
        char[] ch = str.toCharArray();
        for (int i=1;i<n;){
            if (ch[i]=='G' && ch[i-1]=='B')
            {
                ch[i-1]='G';
                ch[i]='B';
                i+=2;
            } else i++;
        }
        return toString(ch);
    }

    public static String toString(char[] ch){
        return new String(ch);
    }
}