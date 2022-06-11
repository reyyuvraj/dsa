package self.leetcode;

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long res = (long) spells[i] * potions[j];
                if (res >= success) {
                    pairs[i] = m - j;
                    break;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        System.out.println(Arrays.toString(new SuccessfulPairsSpellsPotions().successfulPairs(spells, potions, success)));
    }
}
