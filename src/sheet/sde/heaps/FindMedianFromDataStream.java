package sheet.sde.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> list;
    int mid, size;
    boolean oddLength;

    public FindMedianFromDataStream() {
        list = new PriorityQueue<>();
        oddLength = false;
        mid = 0;
        size = 0;
    }

    public void addNum(int num) {
        list.add(num);
        oddLength = !oddLength;
        size++;
        if (oddLength)
            mid = (int) Math.floor(((double) size) / 2);
    }

    public double findMedian() {
        double res = 0;
        int temp = mid;

        if (oddLength){
            while (temp>=0){
                res = list.peek();
                temp--;
            }
        } else {
            double r = 0;
            while (temp+1>=0){
                r = res;
                res = list.peek();
                temp--;
            }
            res += r;
            res /= 2;
        }

        return res;
    }
}
