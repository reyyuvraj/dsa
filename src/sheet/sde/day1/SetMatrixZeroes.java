package sheet.sde.day1;


public class SetMatrixZeroes {

    private static void convertToZero(int[][] arr) {
        int m= arr.length;
        int n= arr[0].length;
        for (int i = 0; i < m; i++)
            arr[i][n-1] = 0;
        for (int i = 0; i < n; i++)
            arr[m-1][i] = 0;
    }

    public static void main(String[] args) {
        int m=5, n=8;
        int[][] arr = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (arr[i][j]==0){
                    convertToZero(arr);
                    break;
                }
            }
        }
    }
}
