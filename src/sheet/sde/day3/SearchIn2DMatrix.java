package sheet.sde.day3;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length,i = 0, j = m;

        while (j >= 0 && i <= n) {
            if (target == matrix[i][j])
                return true;
            else if (target > matrix[i][j]) {
                j++;
            } else {
                i++;
            }
        }

        return false;
    }

    public static boolean searchMatrixO(int[][] matrix, int target) {

        int m=matrix.length-1;
        int n=matrix[0].length-1;

        int i=0;
        int j=matrix.length-1;
        while(i<=matrix[0].length-1 && j>=0){
            if(matrix[j][i]==target){
                return true;
            }
            else if(target>matrix[j][i]){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}