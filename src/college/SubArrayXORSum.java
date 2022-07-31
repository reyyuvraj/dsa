package college;

import java.util.HashMap;

public class SubArrayXORSum {

    public static int calculate(int[] arr) {
        int n= arr.length;
        int maxi=0;
        XORSubArray obj=new XORSubArray();
        int[][] count=new int[32][n];
        obj.preprocess(arr, n, count);

        HashMap<Integer, HashMap<Integer, Integer>> hm= new HashMap<>();

        for (int i=0;i<n;i++) {
            hm.put(i, new HashMap<>());
            for (int j=0;j<n;j++) {
                int xor= obj.findXOR(i, j, count);
                hm.get(i).put(j, xor);
            }
        }

        for (int a=0;a<n;a++) {
            for (int b=a;b<n;b++) {
                for (int c=b+1;c<n;c++) {
                    for (int d=c;d<n;d++) {
                        int c1=hm.get(a).get(b);
                        int c2=hm.get(c).get(d);
                        maxi=Math.max(maxi, c1+c2);
                    }
                }
            }
        }

        return maxi;
    }

    public static void main(String[] a) {
        int[] arr={5,1,2,3,1,2};
        System.out.println(calculate(arr));
    }
}

class XORSubArray
{
    public void preprocess(int[] arr, int n, int[][] cnt)
    {
        int i, j;

        for (i = 0; i < 32; i++)
        {
            cnt[i][0] = 0;
            for (j = 0; j < n; j++)
            {
                if (j > 0)
                {
                    cnt[i][j] = cnt[i][j - 1];
                }

                if ((arr[j] & (1 << i)) >= 1)
                    cnt[i][j]++;
            }
        }
    }

    public int findXOR(int L, int R, int[][] cnt)
    {
        int ans = 0;

        int noOfOnes;

        int i;

        for (i = 0; i < 32; i++)
        {
            noOfOnes = cnt[i][R] - ((L > 0) ? cnt[i][L - 1] : 0);
            if (noOfOnes % 2 == 1)
            {
                ans += (1 << i);
            }
        }

        return ans;
    }
}

class SegmentTreeXOR {

    int[] tree;
    int n;

    public SegmentTreeXOR(int[] arr) {
        n=arr.length;
        tree=new int[n<<1];
        buildTree(arr);
    }

    private void buildTree(int[] arr) {
        for(int i=n;i<n<<1;i++)
            tree[i]=arr[i-n];

        for(int i=n-1;i>0;i--)
            tree[i]=tree[i<<1]^tree[i<<1|1];
    }

    public void update(int index, int val) {
        for(tree[index += n] = val; index > 0; index >>= 1)
            tree[index >> 1] = tree[index] ^ tree[index ^ 1];
    }

    public int xorRange(int left, int right) {
        int res = 0;
        for (left += n, right += n; left <= right; left >>= 1, right >>= 1) {
            if ((left & 1) == 1) res ^= tree[left++];
            if ((right & 1) == 0) res ^= tree[right--];
        }
        return res;
    }
}
