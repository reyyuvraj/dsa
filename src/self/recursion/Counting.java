package self.recursion;

public class Counting {

    static void ascending(int n) {
        if (n > 0) {
            ascending(n - 1);
            System.out.print(n + " ");
        }
    }

    static void descending(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            descending(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ascending(n);
        System.out.println();
        descending(n);
        System.out.println();
        System.out.println();
    }
}
