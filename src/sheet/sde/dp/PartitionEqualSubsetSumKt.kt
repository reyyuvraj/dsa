package sheet.sde.dp

class PartitionEqualSubsetSumKt {

    fun canPartition(arr: IntArray): Boolean {
        val len = arr.size
        var sum = 0

        for (i in arr)
            sum += i

        if (sum%2==1) return false;

        return f(arr, sum/2)
    }

    private fun f(arr: IntArray, target: Int): Boolean {
        val len = arr.size

        val dp = Array(len) { BooleanArray(target + 1) }

        for (i in 0 until len-1) dp[i][0] = true

        dp[0][arr[0]] = true

        for (ind in 1 until len){
            for (trg in 1 until target){
                val notTake = dp[ind-1][trg];
                var take = false
                if (arr[ind]<=trg)
                    take = dp[ind-1][trg-arr[ind]]
                dp[ind][trg] = take || notTake
            }
        }

        return dp[len-1][target]
    }
}