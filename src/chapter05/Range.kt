package chapter05

class Range {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Range()
            t.sayHello()
        }
    }

    fun sayHello() {
        val range = 3..8
        println(2.coerceIn(range))
        println(5.coerceIn(range))

        val min = 10
        val max = 200
        println(5.coerceIn(min, max))
        println(60.coerceIn(min, max))
        chunked()
        windowed()
        des()
    }

    fun chunked() {
        val range = 2..5
        val chunked = range.chunked(3)
        println(chunked)
    }

    fun windowed() {
        val range = 0..10
        val windowed = range.windowed(3)
        println(windowed)
    }

    fun des() {
        val list = listOf("asd", "bfgb", "casd", "dasd", "easd", "fdas", "gasd")
        val (a, b, c, d, e) = list
        println("$a $b $c $d $e")
    }
}