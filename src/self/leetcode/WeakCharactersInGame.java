package self.leetcode;

import java.util.*;

public class WeakCharactersInGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int[][] game = new int[row][2];
        System.out.println(numberOfWeakCharacters(game));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        HashSet<Integer> hm = new HashSet<>();

        for (int i = 0; i < properties.length; i++) {
            for (int j = 0; j < properties.length; j++){
                if (i==j)
                    continue;
                if (properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1] && !hm.contains(j)){
                    hm.add(j);
                    count++;
                }
            }
        }
        return count;
    }
}
//[[7,7],[1,2],[9,7],[7,3],[3,10],[9,8],[8,10],[4,3],[1,5],[1,5]]