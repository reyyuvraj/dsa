package self.leetcode

import java.util.*

class MaximumUnitsOnTruckKln {

    //sorting in descending order
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        var truckCapacity = truckSize
        Arrays.sort(boxTypes) { a: IntArray, b: IntArray ->
            b[1].compareTo(a[1])
        }
        var res = 0
        for (box in boxTypes) {
            if (truckCapacity >= box[0]) {
                res += box[0] * box[1]
                truckCapacity -= box[0]
            } else {
                res += truckCapacity * box[1]
                return res
            }
        }
        return res
    }

    //counting sort
    fun maximumUnitsSecond(boxTypes: Array<IntArray>, truckSize: Int): Int {
        var truckCapacity = truckSize
        val count = IntArray(1001)
        for (box in boxTypes) {
            count[box[1]] += box[0]
        }
        var res = 0
        for (i in 1000 downTo 1) {
            if (count[i] > 0) {
                val limit = Math.min(count[i], truckCapacity)
                res += i * limit
                truckCapacity -= limit
                if (truckCapacity == 0) return res
            }
        }
        return res
    }
}

fun main() {
    val arr = arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1))
    val obj = MaximumUnitsOnTruckKln()
    println(obj.maximumUnits(arr, 4))
}