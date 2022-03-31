package self.leetcode;

public class EvenDigitSum {

    public  int countEven(int num) {
        int count = 0;
        for (int i = 1; i<=num;i++){
            if (sum(i)%2==0)
                count++;
        }
        return count;
    }

    public int sum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        int num = 30;
        System.out.println(new EvenDigitSum().countEven(num));
    }
}