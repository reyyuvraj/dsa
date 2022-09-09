package self.kotlin.generics

class Box<T>(t: T) {
    var value = t
}

val box = Box(1)

interface Test<T> {
    fun a(a: T): T
}

class A : Test<Int> {
    override fun a(a: Int): Int {
        return a
    }

    val res = a(2)

    companion object One : Test<Int> {
        val above = a(4)

        override fun a(a: Int): Int {
            return a
        }

        val r = a(3)
    }
}

fun A.One.printCompanion() {
    println("above = $above, r = $r")
}

fun main() {
    println(box)
    println(box.value)
    println(A().res)
    println(A.r)
    println(A.above)
    println(list.swap(0, 2))
    println(list)
    list.forEach {
        print("$it ")
    }
    println()
    A.printCompanion()
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

val list = mutableListOf(1, 2, 3)
