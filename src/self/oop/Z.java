package self.oop;

class A {

    private int privateA = 1;
    protected int protectedA = 2;

    A() {
        System.out.println("A's default constructor");
    }

    public void print() {
        System.out.println("Print of A");
    }

    public void doesA() {
        System.out.println("A does");
    }

    private void privateFun() {
        System.out.println("Private function");
    }

    protected void protectedFunA() {
        System.out.println("Protected function A");
    }
}

class B extends A {

    private int privateB = 3;
    protected int protectedB = 4;

    B() {
        System.out.println("B's default constructor");
    }

    public void print() {
        System.out.println("Print of B");
    }

    public void doesB() {
        System.out.println("B does");
    }

    protected void protectedFunB() {
        System.out.println("Protected function B");
    }
}

class C extends B {

    C() {
        System.out.println("C's default constructor");
    }

    public void print() {
        System.out.println("Print of C");
    }

    public void doesC() {
        System.out.println("C does");
    }
}

public class Z {
    public static void main(String[] args) {
        //variable type same as object call
        A a = new A();
        a.print();
        System.out.println("\n");

        B b = new B();
        b.print();
        b.protectedFunA();
        System.out.println("\n");

        C c = new C();
        c.print();
        c.doesA();
        c.doesB();
        c.doesC();
        c.protectedFunA();
        System.out.println("\n");
        //parent class constructor is called in the order of inheritance.
        //functions with same name in the child class override the content for its object --
        //-- this means the content of the child function will be printed
        //child class cannot inherit private members of a parent class.
        //child class can inherit protected members of a parent class.
        //protectedFunA in B overrides the function in A, so when this is inherited in C --
        //-- modified content is printed. Inheritance is hierarchical.

        //variable type differs from object call
        A ab = new B();
        ab.print();
        ab.protectedFunA();
        // ab.protectedFunB() cannot be called
        ab.doesA();
        // ab.doesB() cannot be called
        System.out.println(ab.protectedA + "\t");
        // ab.protectedB cannot be called
        System.out.println("\n");

        A ac = new C();
        ac.print();
        ac.doesA();
        // ac.doesB() and ac.doesC() cannot be called
        System.out.println(ac.protectedA + "\t");
        // ac.protectedB cannot be called
        System.out.println("\n");

        B bc = new C();
        bc.print();
        bc.doesA();
        bc.doesB();
        System.out.println(bc.protectedA + "\t" + bc.protectedB);
        System.out.println("\n");
        //we deduce that the type of the function that can be called from an object is dependent --
        //-- on the type of the object so even if you call a child constructor its members --
        //-- cannot be accessed
        //Example A obj = new C() can call functions from A and not from B but if they are changed in --
        //-- the constructor called then its modified content is printed.

        //In summary, you now understand that "obj" properties can be accessed based on the "obj" type --
        //-- and its members are modified in accordance to the constructor called.
    }
}
