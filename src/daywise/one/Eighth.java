package daywise.one;

public class Eighth {
    int num = 100;
    public void calc(int num)  { this.num = num * 10;  }
    public void printNum() { System.out.println(num); }

    public static void main(String[] args)
    {
        Eighth obj = new Eighth();
        obj.calc(2);
        obj.printNum();
    }
}
