package sheet.sde.dp

import java.util.*

class LongestIncreasingSubsequenceKt {

    fun maxProduct(arr: IntArray): Int {
        val n = arr.size
        val dp = Array(n) { IntArray(n + 1) }
        for (i in dp) Arrays.fill(i, -1)
        return helper(0, -1, arr, n, dp)
    }

    private fun helper(ind: Int, prev_ind: Int, arr: IntArray, n: Int, dp: Array<IntArray>): Int {
        if (ind == n) return 0

        if (dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1]

        var len = helper(ind + 1, prev_ind, arr, n, dp)

        if (prev_ind == -1 || arr[ind] > arr[prev_ind]) len = Math.max(len, 1 + helper(ind + 1, ind, arr, n, dp))

        return len.also { dp[ind][prev_ind + 1] = it }
    }
}