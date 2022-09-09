package self.leetcode;

public class AvoidConsecutiveCharacters {
    public String modifyString(String s) {
        StringBuilder sbr=new StringBuilder(s);
        int firstIndex=s.indexOf("?");
        int lastIndex=s.indexOf("?");
        int n=s.length();

        for(int i=firstIndex;i<=lastIndex;i++) {
            if(s.charAt(i)=='?'){
                char before=s.charAt(i-1);
                char after=s.charAt(i+1);
                char c=' ';
                if(i-2>=0) c=s.charAt(i-2);
                if(i+2<n) c=s.charAt(i+2);
                s=s.substring(0, i-1)+c+s.substring(i-2);
            }
        }

        return s;
    }
}
