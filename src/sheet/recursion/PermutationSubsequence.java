package sheet.recursion;

public class PermutationSubsequence {

    public String getPermutation(int n, int k) {
        int[] arr=new int[n];
        int startIndex=0, endIndex=n-1;
        for(int i=0;i<n;i++)
            arr[i]=i+1;

        return arrayToString(arr, n);
    }

    public int factorial(int n){
        if(n==0 || n==1) return 1;
        return n*factorial(n-1);
    }

    public String arrayToString(int[] arr, int n){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
            res.append(arr[i]);

        return res.toString();
    }
}
