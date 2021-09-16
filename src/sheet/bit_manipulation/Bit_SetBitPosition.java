package sheet.bit_manipulation;

public class Bit_SetBitPosition {

    public static boolean isPowerOfTwo(int n){
        return ((n>0) && ((n & (n-1))==0));
    }

    static int findPosition(int n){
        if(!isPowerOfTwo(n))
            return -1;

        int i=1,pos=1;

        while ((i & n) ==0){
            i = i<<1;
            ++pos;
        }
        return pos;
    }

    public static void main(String[] args){
        int n = 4;
        System.out.println(findPosition(n));
    }
}