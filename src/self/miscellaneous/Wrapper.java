package self.miscellaneous;

public class Wrapper {

    static void wrapper(Integer a, Integer b){
        if (a==b)
            System.out.println("A equals B");
        else
            System.out.println("A not equals B");
    }

    static void unboxing(Integer a, int b){
        if (a==b)
            System.out.println("A equals B");
        else
            System.out.println("A not equals B");
    }

    static void wrapperEquals(Integer a, Integer b){
        if (a.equals(b))
            System.out.println("A equals B");
        else
            System.out.println("A not equals B");
    }

    public static void main(String[] args){
        int a=200;
        int b=200;
        wrapper(a,b);
        unboxing(a,b);
        wrapperEquals(a,b);
    }
}