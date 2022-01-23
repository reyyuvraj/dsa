package daywise.one;

public class Seventh {
    public static void main(String args[])
    {
        short s = 0;
        int x = 07;
        int y = /*0*/8;//Any number beginning with zero is treated as an octal number (which is 0-7).
        int z = 112345;

        s += z;
        System.out.println("" + x + y + s);
    }
}
