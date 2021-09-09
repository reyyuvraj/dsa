public class Bit_PowerSet {

    public static void powerSet(String s){
        int n = s.length();
        int powerSize = (int)Math.pow(2,n);
        for(int i=0;i<powerSize;i++){
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0)
                    System.out.print(s.charAt(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        String str = "abc";
        powerSet(str);
    }
}