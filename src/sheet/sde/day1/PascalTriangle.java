package sheet.sde.day1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void printPascal(List<List<Integer>> a){
        List<Integer> al = a.get(a.size()-1);
        List<Integer> res = new ArrayList<>();

        res.add(1);

        for (int i=1;i<al.size()-1;i++){
            res.add(al.get(i)+al.get(i+1));
        }

        res.add(1);

        a.add(res);
    }

    public static void main(String[] args){
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a.add(a1);
        a1.add(1);
        a.add(a1);
        for (int i=1;i<=5;i++){
            printPascal(a);
        }

        System.out.println(a);
    }
}
