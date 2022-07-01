package self.leetcode

class MaximumProductSubArrayKt {

    fun maxProduct(arr: IntArray): Int {
        var res = arr[0]
        var tempMax = 1
        var tempMin = 1
        for (num in arr) {
            val tMax = num * tempMax
            val tMin = num * tempMin
            tempMax = tMax.coerceAtLeast(tMin.coerceAtLeast(num))
            tempMin = tMax.coerceAtMost(tMin.coerceAtMost(num))
            res = tempMax.coerceAtLeast(res)
        }
        return res
    }
}

fun main(args: Array<String>) {
    val a = intArrayOf(2, 3, -2, 0, 4)
    println(MaximumProductSubArray().maxProduct(a))
}
