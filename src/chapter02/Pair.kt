package chapter01

class Pair {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Pair()
            t.sayHello()
        }
    }

    fun sayHello(){
        printOff()
    }

    fun printOff() {
        val map = mutableMapOf("a" to 1, "b" to 2, "c" to 2)
        println(map.containsKey("a"))
        val boom = map.containsValue(77)
        println(boom)
    }
}