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
    }

    class Person(val first: String,
                 val middle: String?,
                 val last: String) {

    }
}