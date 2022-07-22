package college;


import java.util.*;

public class ColorMixture {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 1; i <= M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            hm.put(x, y);
            hm.put(y, x);
        }

        ArrayList<Integer> colors = new ArrayList<>();
        int[] col = new int[N];

        for (int i = 1; i <= N; i++) {
            colors.add(i);
            col[i-1] = i;
        }

        List<List<Integer>> subsets;
        subsets = subsets(col);
        int count = 0;

        for (List<Integer> temp : subsets)
            if (check(temp, hm)) {
                System.out.println(temp);
                count++;
            }

        System.out.println(count);
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(list, new ArrayList<>(), arr, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list ,
                           List<Integer> tempList,
                           int [] arr,
                           int start)
    {
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < arr.length; i++){
            tempList.add(arr[i]);
            backtrack(list, tempList, arr, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static boolean check(List<Integer> subset,
                                 HashMap<Integer, Integer> hm) {

        System.out.println(subset);
        for (Integer num: subset){
            if (hm.containsKey(num)){
                int n = hm.get(num);

            }
        }

        return true;
    }
}
