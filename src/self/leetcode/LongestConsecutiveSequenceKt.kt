package self.leetcode


class LongestConsecutiveSequenceKt {

    fun longestConsecutiveOp(arr: IntArray): Int {
        val hashSet = hashSetOf<Int>()

        for (num in arr)
            hashSet.add(num)

        var longestStreak = 1

        for (num in arr) {
            if (!hashSet.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }

                longestStreak = longestStreak.coerceAtLeast(currentStreak)
            }
        }

        return longestStreak
    }

    fun longestConsecutive(arr: IntArray): Int {
        val hashSet: MutableSet<Int> = HashSet()
        for (num in arr) {
            hashSet.add(num)
        }
        var longestStreak = 0
        for (num in arr) {
            if (!hashSet.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1
                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }
                longestStreak = longestStreak.coerceAtLeast(currentStreak)
            }
        }
        return longestStreak
    }
}