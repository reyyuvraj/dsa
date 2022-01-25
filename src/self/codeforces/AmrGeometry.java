package self.codeforces;

import java.util.*;

public class AmrGeometry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int $x = in.nextInt();
        int $y = in.nextInt();

        double steps = Math.sqrt(Math.pow(x-$x, 2)+Math.pow(y-$y, 2));
        double distance = 2 * r;
        int count = (int) (steps / distance);
        if (count*(int)distance < steps)
            count++;
        System.out.println(count);
    }
}