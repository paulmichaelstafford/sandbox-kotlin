package chapter01

import kotlin.math.pow

class POW {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = POW()
            t.sayHello()
        }
    }

    fun sayHello(){
        println(raise(23, 123.4))
        println(2 `**` 2)
    }

    fun raise(number: Int, pow: Double): Int {
        return number.toDouble().pow(pow).toInt()
    }

    fun Long.pow(x: Int) = toDouble().pow(x).toLong()
    fun Int.pow(x: Int) = toDouble().pow(x).toInt()
    infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()
    infix fun Long.`**`(x: Int) = toDouble().pow(x).toInt()
    infix fun Float.`**`(x: Int) = toDouble().pow(x).toFloat()
    infix fun Double.`**`(x: Int) = toDouble().pow(x)
}