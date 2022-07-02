package sheet.sde.dp


class LongestCommonSubsequence {

    fun longestCommonSubsequence(s: String, t: String): Int {
        val m = s.length
        val n = t.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 0 until m)
            for (j in 0 until n)
                if (s[i] == t[j]) dp[i + 1][j + 1] = 1 + dp[i][j]
                else dp[i + 1][j + 1] = dp[i][j + 1].coerceAtLeast(dp[i + 1][j])

        return dp[m][n]
    }
}

fun main(){
    val s = "abcde"
    val t = "ace"
    val obj = LongestCommonSubsequence()
    println(obj.longestCommonSubsequence(s, t))
}