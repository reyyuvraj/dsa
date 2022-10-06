package self.miscellaneous;

import java.util.HashMap;

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point p) {
        int dx = Math.abs(x - p.getX());
        int dy = Math.abs(y - p.getY());

        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class Perimeter {

}
