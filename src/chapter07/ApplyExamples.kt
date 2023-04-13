package chapter07

class ApplyExamples {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = ApplyExamples()
            t.sayHello()
        }
    }

    fun sayHello() {
        applyExample()
        letExample("heLLo")
        letNullableExample("asd")
        letNullableExample(null)
        chainLet()
    }

    data class Golfer(var name: String) {
        var id: Int? = null
    }

    fun applyExample() {
       val golfer1 = Golfer("paul").apply { id = 123; name = "asd"}
        println(golfer1)
    }

    fun letExample(boom: String) {
        val asd = boom.let {
            boom.uppercase()
        }
        println(asd)
        println(boom)
    }

    fun letNullableExample(boom: String?) {
        val asd = boom?.let {
            boom.uppercase()
        } ?: "it's null!!!"
        println("what am I $asd")
    }

    fun chainLet() {
        val numbers = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numbers.map { it.length }.filter { it > 3 }
        println(resultList)


        val numbers1 = mutableListOf("one", "two", "three", "four", "five")
        numbers1.map { it.length }.filter { it > 3 }.let {
            println(it)
        }
        numbers1.map { it.length }.filter { it > 1 }.let(::println)
    }

}