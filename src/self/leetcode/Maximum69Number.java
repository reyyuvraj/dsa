package self.leetcode;

public class Maximum69Number {

    public int maximum69Number (int num) {
        String n = Integer.toString(num);
        int index = n.indexOf('6');
        if (index>=0)
            n = n.substring(0, index)+'9'+n.substring(index+1);
        return Integer.parseInt(n);
    }

}
