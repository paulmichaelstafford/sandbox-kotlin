package chapter05

class Collections {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Collections()
            t.sayHello()
        }
    }

    fun sayHello() {
        val squares = Array(4) { i -> println(i); i }
        squares[0] = 19
        println(squares[0])
        println(squares.indices)

        for ((index, value) in squares.withIndex()) {
            println("Index $index maps to $value")
        }
        sayInline()
        testy1()
    }

    fun sayInline() {
        val keys = 'a'..'f'
        val map = keys.associate { it to it.toString().repeat(5).capitalize() }
        println(map)

        val keys1 = 'a'..'f'
        val map1 = keys.associateWith { it.toString().repeat(5).capitalize() }
        println(map1)
    }

    fun testy1() {
        val boom : (List<Product>) -> String = {
            it.filter { it.onSale }
                    .map { it.name }
                    .joinToString(separator = ", ")
                    .ifEmpty { "none" }
        }
        println(boom(listOf(
                Product("paul", 1.2, true),
                Product("asdasd", 7.0, true),
                Product("45565", 6.0))))
        println(boom(listOf(
                Product("paul", 1.2),
                Product("asdasd", 7.0),
                Product("45565", 6.0))))
    }

    data class Product(val name: String,
                       var price: Double,
                       var onSale: Boolean = false)
}