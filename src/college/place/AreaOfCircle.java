package college.place;

import java.util.*;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt();
        float area = (float) (3.14 * radius * radius);
        System.out.println(area);
    }
}
