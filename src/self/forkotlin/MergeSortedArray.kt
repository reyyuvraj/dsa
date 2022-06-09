package self.forkotlin

class MergeSortedArray {
    private fun merge(array1: IntArray, m: Int, array2: IntArray, n: Int): Unit {
        var i: Int = m - 1;
        var j = n - 1;
        var k = m + n - 1

        while (i >= 0 && j >= 0) {
            if (array1[i] <= array2[j])
                array1[k--] = array2[j--]
            else
                array1[k--] = array1[i--]
        }

        while (j >= 0)
            array1[k--] = array2[j--]
    }

    fun removePalindromeSub(s: String): Int {
        var i=0
        var j=s.length-1

        while(i<j){
            if(s[i]==s[j]){
                i++
                j--
            } else return 2
        }

        return 1
    }

    fun main(){
        val array1: IntArray = intArrayOf(1,2,3,0,0,0)
        val array2 = intArrayOf(4,5,6)
        merge(array1, 3, array2, 3)
        println(array1.toString())
    }
}