package sheet.bit_manipulation;

public class Bit_SetIntegerBit {

    public static int setBitCount(int n){
        int res=0;
        while(n>0){
            n=n&(n-1);
            res++;
        }
        return res;
    }

    public static void main(String[] args){
        int n = 9;
        System.out.println("Number of set bits in "+n+" is "+setBitCount(n));
    }
}