package recursion;

public class Counting {
    public static int doAscendingCount(int n, int k){
        if(k<=n){
            System.out.print(k+" ");
            return doAscendingCount( n,k+1);
        }
        return k;
    }

    public static int doDescendingCount(int n){
        if(n==0){
            return 0;
        }
        System.out.print(n+" ");
        return doDescendingCount(n-1);
    }

    public static void main(String[] args){
        int n = 5;
        doAscendingCount(n,1);
        System.out.println();
        doDescendingCount(n);
    }
}
