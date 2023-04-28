package functionalsandpit

class Functional001 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Functional001()
            t.sayHello()
        }
    }

    fun sayHello() {
        val paul = Student(1, "paul")
        val chris = Student(1, "chris")
        val john = Student(1, "john")

        val c1Students = listOf(paul, chris)
        val c2Students = listOf(john, paul)

        val c1 = Class(1, "hard knocks", c1Students)
        val c2 = Class(2, "life", c2Students)

        val classes = listOf(c1, c2)

        classes.flatMap { it.students }.toSet().forEach {
            println(it)
        }
        println("----------------")
        classes.flatMap { it.students }.forEach {
            println(it)
        }
        println("----------------")
        val reduceOfIds = classes.flatMap { it.students }.map {it.id}.reduce { result, item -> result * item }
        println("reduceOfIds[$reduceOfIds]")

        val chunkedStudents = classes.flatMap { it.students }.chunked(2)
        println("chunkedStudents[$chunkedStudents]")

        val sum = classes.flatMap { it.students }.map{ it.id }.sum()
        println("sum[$sum]")

        val toList = classes.flatMap { it.students }.toList()
        println("toList[$toList]")

        val toSet = classes.flatMap { it.students }.toSet()
        println("toSet[$toSet]")

        val withIndex = classes.flatMap { it.students }.toList().withIndex().toList()
        println("withIndex[$withIndex]")

        val map = mutableMapOf(1 to 1)
        val default = map.withDefault { k -> k * 2 }
        val withDefault = default.getValue(10)
        println("withDefault[$withDefault]")

        println("----------------")

        val list = listOf(1)
        val mutableList = mutableListOf(1)
        println(list)          // [1]
        println(mutableList)   // [1]
        val newList = list.plus(2)
        mutableList.add(2)
        println(list)          // [1]
        println(newList)       // [1, 2]
        println(mutableList)   // [1, 2]

        println("----------------")

    }

    data class Student(val id: Int, val name: String)
    data class Class(val id: Int, val name: String, val students: List<Student>)



}