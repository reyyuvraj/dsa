package self.leetcode;

import java.util.ArrayList;

public class BaseballGame {

    public int calPoints(String[] ops) {
        ArrayList<Integer> al = new ArrayList<>();
        for (String op : ops) {
            String i = op;
            boolean neg = false;
            if (i.equals("C") || i.equals("D") || i.equals("+")) {
                if (i.equals("C")) {
                    al.remove(al.size() - 1);
                }

                if (i.equals("D")) {
                    int b = al.get(al.size() - 1) * 2;
                    al.add(b);
                }

                if (i.equals("+")) {
                    int b1 = al.get(al.size() - 1);
                    int b2 = al.get(al.size() - 2);
                    al.add(b1 + b2);
                }
            } else {
                if (i.charAt(0) == '-') {
                    neg = true;
                    i = i.substring(1);
                }
                int num = Integer.parseInt(i);
                if (neg) num *= -1;
                al.add(num);
            }
        }
        int sum = 0;
        for (int k : al) {
            sum += k;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5"};
        System.out.println(new BaseballGame().calPoints(ops));
    }
}
