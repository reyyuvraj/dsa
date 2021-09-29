package self.miscellaneous;

public class Test {

    static void wrapper(Integer a, Integer b) {
        if (a == b)
            System.out.println("A equals B");
        else
            System.out.println("A not equals B");
    }

    public static void main(String[] args) {
        int a = 200;
        int b = 200;
        wrapper(a, b);
        a = 50;
        b = 50;
        wrapper(a, b);
    }
}