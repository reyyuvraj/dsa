package self.leetcode

import java.util.*


class CandyKt {

    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size)
        Arrays.fill(candies, 1)


        for (i in 1 until candies.size) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1
        }

        for (i in candies.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) candies[i] = candies[i].coerceAtLeast(candies[i + 1] + 1)
        }

        var sum = 0
        for (candy in candies) sum += candy
        return sum
    }
}
