package self.recursion;

public class Test {

    public static void main(String[] args){
        Test test = new Test();
        test.ev(4, 2.5f);
        String a = "hello";
        String ds = new String(a);
        System.out.println(a.equals(ds));
        System.out.println(Math.abs(-2.9));
    }

    public void ev(int a, int b){
        System.out.println("First");
        System.out.println(a+b);
    }

    public void ev(float a, float b){
        System.out.println("Second");
        System.out.println(a+b);
    }
}
