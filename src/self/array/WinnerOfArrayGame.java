package self.array;

import java.util.ArrayList;

public class WinnerOfArrayGame {

    public int getWinner(int[] arr, int k) {
        StringBuilder sbr = new StringBuilder("sadsa");
        sbr.charAt(0);
        String s = "asdada";
        char c = s.charAt(2);

        int len=arr.length, max=0, count=0, winner=0;

        ArrayList<Integer> list = new ArrayList<>();

        if (k>=len) k = len - 1;

        for(int i: arr)
            list.add(i);


        do {
            if (list.get(0) > list.get(1)) {
                int w = list.get(0);
                count++;
                int num = list.get(1);
                list.remove(1);
                list.add(num);
                if (max < count) {
                    max = count;
                    winner = w;
                }
            } else if (list.get(0) < list.get(1)) {
                int w = list.get(1);
                count = 1;
                int num = list.get(0);
                list.set(0, list.get(1));
                list.remove(1);
                list.add(num);
                if (max <= count) {
                    max = count;
                    winner = w;
                }
            }

        } while (max != k);

        return winner;
    }
}
