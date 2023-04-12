package chapter03

class OverloadingOperators {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = OverloadingOperators()
            t.sayHello()
        }
    }

    fun sayHello(){
        val point = Point(10, 20)
        operator fun Point.unaryMinus(): Point = Point(-x, -y)
        println(point)
        println(point.boom())
        println(-point)
    }


    data class Point(val x: Int, val y: Int) {
        operator fun Point.unaryMinus(): Point = Point(-x*2, -y*2)
        fun boom() {
            println(-this)
        }
    }
}