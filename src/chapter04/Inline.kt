class Inline {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Inline()
            t.sayHello()
        }
    }

    fun sayHello(){
        println(sum(2,2,2,2,2))

        val square = { number: Int -> number * number }
        val squareString: (Int) -> String = { number: Int -> (number * number).toString() }
        val squareUnit: (Int) -> Unit = { number: Int -> println((number * number).toString()) }
        println(square(3))
        println(squareString(16))
        println(squareUnit(65))
        println(test(7, square))
        println(extendString("test", 7))
        boomtest()
        testyMcTestFact()
    }

    fun sum(vararg nums: Int): Int {
        var boom1 =  nums.fold(0) { acc, n -> acc + n }
        return boom1;
    }

    //val lambdaName : Type = { argumentList -> codeBody }
    fun extendString(arg: String, num: Int) : String {
        val another : String.(Int) -> String = { this + it } //this == string and It is the number


//        val anotherExample : Int -> Int = { three:Int -> 2 }
        val more : (String, Int) -> String = { str, int -> str + int }
        return arg.another(num)
    }

    inline fun <R> test(initial: R, operation: Any ): R {
        return initial;
    }

    fun boomtest(): Unit {
        val more : (String, Int) -> String = { str, int -> str + int }

        val lambda1 = { arg: Int ->
            arg == 3
        }
        val lambda2 = { arg: Int ->
            arg == 5
        }
        val result1 = invokeLambda(lambda1)
        val result2 = invokeLambda(lambda2)
        println(result1)
        println(result2)
    }

    fun invokeLambda(lambda: (Int) -> Boolean) : Boolean {
        return lambda(3)
    }


    fun testyMcTestFact() {
        val lambda1 : (String,Int) -> String = {three, boom -> three + boom}
        println(lambda1("redDead", 2))
        println(testyMcLambdaFace(lambda1, "asdasdasd", 2))
    }

    fun testyMcLambdaFace(boom: (String,Int) -> String, testyString: String, testInt: Int): String {
        return boom(testyString, testInt)
    }
}