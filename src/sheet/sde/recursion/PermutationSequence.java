package sheet.sde.recursion;

import java.util.ArrayList;

public class PermutationSequence {

    public String getPermutation(int n, int k){
        int factorial = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for (int i=1;i<n;i++){
            factorial *= i;
            arr.add(i);
        }
        arr.add(n);
        --k;

        while (true){
            int index = k/factorial;
            res.append(arr.get(index));
            arr.remove(index);

            if (arr.size()==0) break;

            k%=factorial;
            factorial/= arr.size();
        }

        return res.toString();
    }
}
