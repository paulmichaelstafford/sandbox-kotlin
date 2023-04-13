package chapter05

class Sorting {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Sorting()
            t.sayHello()
        }
    }

    fun sayHello() {
        sort()
        anotherSort()
    }

    data class Golfer(val score: Int, val first: String, val last: String)

    val golfers = listOf(
        Golfer(70, "Jack", "Nicklaus"),
        Golfer(68, "Tom", "Watson"),
        Golfer(68, "Bubba", "Watson"),
        Golfer(71, "Tiger", "Woods"),
        Golfer(68, "Ty", "Webb"))

    fun sort() {
        val sorted = golfers.sortedWith(
            compareBy({ it.score }, { it.last }, { it.first })
        )
        println(sorted)
    }

    fun anotherSort() {
        val comparator = compareBy(Golfer::score)
            .thenBy(Golfer::last)
            .thenBy(Golfer::first)
        golfers.sortedWith(comparator)
            .forEach(::println)
    }

}