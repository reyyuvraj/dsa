package self.array;


public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] arr = {30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(minEatingSpeed(arr, h));
    }

    private static int minEatingSpeed(int[] arr, int h) {
        int min = 1, max = Integer.MAX_VALUE;

        while (min < max) {
            int x = 0, mid = min + (max - min) / 2;
            for (int i : arr)
                x += Math.ceil(i * 1.0 / mid);
            if (x > h)
                min = x + 1;
            else
                max = mid;
        }
        return max;
    }
}