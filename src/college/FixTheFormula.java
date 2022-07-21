package college;

public class FixTheFormula {

    public int fixTheFormula(String input1){
        StringBuffer alpha = new StringBuffer();
        StringBuffer num = new StringBuffer();
        StringBuffer special = new StringBuffer();
        int res = 0;

        for (int i = 0; i < input1.length(); i++) {
            if (Character.isDigit(input1.charAt(i)))
                num.append(input1.charAt(i));
            else if (Character.isAlphabetic(input1.charAt(i)))
                alpha.append(input1.charAt(i));
            else
                special.append(input1.charAt(i));
        }

        String sNum = num.toString();
        String sSpecial = special.toString();
        res = sNum.charAt(0)-'0';

        for (int i=0;i<sSpecial.length();i++){
            char c = sSpecial.charAt(i);
            int n = sNum.charAt(i+1)-'0';

            if (c=='+') res += n;
            else if(c=='-') res -= n;
            else if(c=='*') res *= n;
            else if (c=='/')  res /= n;
        }

        return res;
    }

    public static void main(String[] args){
        //we8+you2-7to/*32
        //i*-5s-t8h1e4birds
        String str = "i*-5s-t8h1e4birds";
        System.out.print(new FixTheFormula().fixTheFormula(str));
    }
}
