package chapter03

class DataExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = DataExample()
            t.sayHello()
        }
    }

    fun sayHello(){
        val boom1 = Boom(10)
        val boom2 = Boom()
        val boom3 = Boom()
        val booms = setOf(boom1, boom2, boom3)
        print(booms.size)


        val boomData1 = BoomData(10)
        val boomData2 = BoomData()
        val boomData3 = BoomData(1)
        val boomDatas = setOf(boomData1, boomData2, boomData3)
        print(boomDatas.size)

        val copyMe = CopyMe(5)
        val copied = copyMe.copy()
        println(copyMe)
        println(copied)
        println(copied.boom)
    }


    class Boom(val boom: Int = 1)

    data class BoomData(val boom: Int = 1)

    data class CopyMe(val test: Int) {
        var boom: Int = 2
    }
}