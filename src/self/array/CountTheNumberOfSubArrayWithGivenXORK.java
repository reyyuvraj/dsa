package self.array;

import java.util.HashMap;

public class CountTheNumberOfSubArrayWithGivenXORK {

    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> visited = new HashMap<>();
        int c = 0;
        int cpx = 0;
        for (int j : A) {
            cpx = cpx ^ j;
            if (visited.get(cpx ^ B) != null)
                c += visited.get(cpx ^ B);
            if (cpx == B) {
                c++;
            }
            if (visited.get(cpx) != null)
                visited.put(cpx, visited.get(cpx) + 1);
            else
                visited.put(cpx, 1);
        }
        return c;
    }

    public static int xor(int a, int b){
        return a^b;
    }

    public static void main(String[] args){
        int k = xor(13,10);
        System.out.println(k);
        System.out.println(xor(k, 8));
    }
}
