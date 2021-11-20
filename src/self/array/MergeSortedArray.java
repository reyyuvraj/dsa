package self.array;

import java.util.Arrays;

public class MergeSortedArray {

    static int[] mergeSortedArray(int[] a, int[] b){
        int[] merge = new int[a.length+ b.length];

        int i=0,j=0,k=0;

        while (i<a.length && j< b.length){
            if (a[i]<b[j])
                merge[k++]=a[i++];
            else
                merge[k++]=b[j++];
        }
        return merge;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6};
        int[] b = {3,5,7,8};
        System.out.print(Arrays.toString(mergeSortedArray(a, b)));
    }
}