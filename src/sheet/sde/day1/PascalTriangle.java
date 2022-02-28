package sheet.sde.day1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> printPascal(int numRows){
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1;i<=numRows;i++){
            List<Integer> res = new ArrayList<>();
            for (int j=0;j<i;j++){
                if (j==0 || j==i-1)
                    res.add(1);
                else
                    res.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(printPascal(5));
    }
}