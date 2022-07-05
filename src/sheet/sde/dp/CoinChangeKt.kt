package sheet.sde.dp

class CoinChangeKt {

    fun coinChange(coins: IntArray, amount: Int): Int {
        val len = coins.size
        var dp = Array(len) { IntArray(amount + 1) }

        for (i in 0 until amount)
            dp[0][i] = (amount % coins[0])

        return dp[len][amount];
    }
}