package chapter03

class CopyExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = CopyExample()
            t.sayHello()
        }
    }

    fun sayHello(){
        val boom1 = Boom(BoomValue(2))
        val boom2 = boom1.copy()
        boom2.boomValue.boom = 5
        println(boom1.boomValue.boom)
        println(boom2.boomValue.boom)

        val (test) = boom1
        println(test)
        println(boom1)

    }

    data class Boom(val boomValue: BoomValue)

    class BoomValue(var boom: Int = 1)

}