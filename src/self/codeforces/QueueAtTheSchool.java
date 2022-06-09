package self.codeforces;

import java.util.Scanner;
public class QueueAtTheSchool{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        String str = in.next();
        char[] ch = str.toCharArray();

        for(int i=1;i<=t;i++){
            swap(ch, n);
        }

        System.out.println(ch);
    }

    private static void swap(char[] ch, int n){
        for(int i=1;i<n;){
            if(ch[i]=='G' && ch[i-1]=='B'){
                ch[i]='B';
                ch[i-1]='G';
                i+=2;
            } else i++;
        }
    }
}
