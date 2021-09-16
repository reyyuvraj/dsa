package sheet.stack;

class Stack_TwoInAnArray {

    int size;
    int top1, top2;
    int[] arr;

    Stack_TwoInAnArray(int n){
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    void push1(int x){
        if(top1<top2-1){
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    void push2(int x){
        if(top1<top2-1){
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    int pop1(){
        if(top1>=0){
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    int pop2(){
        if(top2<size){
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    public static void main(String[] args){
        Stack_TwoInAnArray ta = new Stack_TwoInAnArray(5);
        ta.push1(5);
        ta.push1(10);
        ta.push2(1);
        ta.push2(2);
        ta.push2(3);
        System.out.println("Popped element from sheet.stack 1 is "+ta.pop1());
        ta.push2(4);
        System.out.println("Popped element from sheet.stack 2 is "+ta.pop2());
    }
}
