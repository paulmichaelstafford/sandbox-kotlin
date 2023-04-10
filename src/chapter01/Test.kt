package chapter01

class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Test()
            t.sayHello()
        }
    }

    fun sayHello(){
        printOff(Person("Joanne", null, "Rowling"))
        printOff(Person("Joanne", "xcz", "Rowling"))
    }

    fun printOff(p: Person) {
        if (p.middle != null) {
            val middleNameLength = p.middle.length
            println(middleNameLength)
        }
        val testy = p.middle?.length ?: boom()
        println(testy)

        val boom1 = p as? String
        println(boom1?.length ?: "what's going onnn")
        val boom2 = p as? Person
        println(boom2?.first ?: "what's going onnn")
    }

    fun boom(): Int {
        return -2
    }

    class Person(val first: String,
                 val middle: String?,
                 val last: String) {

    }
}