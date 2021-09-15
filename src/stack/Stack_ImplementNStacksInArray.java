package stack;

public class Stack_ImplementNStacksInArray {

    static class KStack{
        int[] arr;
        int[] top;
        int[] next;
        int n,k;
        int freeTop;

        KStack(int k1,int n1)
        {
            k=k1;n=n1;
            arr = new int[n];
            top = new int[k];
            next = new int[n];

            for(int i=0;i<n;i++)
                top[i]=-1;

            freeTop=0;

            for(int i=0;i<n-1;i++)
                top[i]=i+1;
            top[n-1]=-1;
        }

        boolean isFull(){ return freeTop==-1;}

        boolean isEmpty(int sn){ return top[sn]==-1;}

        void push(int x, int sn){
            if(isFull()){
                System.out.println("Stack Overflow");
            return;
            }

            int i=freeTop;
            freeTop = next[i];
            next[i] = top[sn];
            top[sn] = i;
            arr[i] = x;
        }

        int pop(int sn){
            if(isEmpty(sn)){
                System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;}
            int i=top[sn];
            top[sn] = next[i];
            next[i] = freeTop;
            freeTop = i;
            return arr[i];
        }
    }

    public static void main(String[] args)
    {
        KStack ms = new KStack(3,10);

        ms.push(15,2);
        ms.push(45,2);

        ms.push(17, 1);
        ms.push(49, 1);
        ms.push(39, 1);

        ms.push(11, 0);
        ms.push(9, 0);
        ms.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ms.pop(2) );
        System.out.println("Popped element from stack 1 is " + ms.pop(1) );
        System.out.println("Popped element from stack 0 is " + ms.pop(0) );
    }
}