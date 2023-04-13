package chapter08

import kotlin.properties.Delegates

class Lazy {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Lazy()
            t.sayHello()
        }
    }

    fun sayHello() {
        boom()
        boom2()
        boom3()
    }
    fun boom() {
        val ultimateAnswer: Int by lazy {
            println("computing the answer")
            42
        }
        println(ultimateAnswer)
        println(ultimateAnswer)
    }
    fun boom2() {
        var shouldNotBeNull: String by Delegates.notNull()
        shouldNotBeNull = "asd"
        println(shouldNotBeNull)
    }
    fun boom3() {
        var shouldNotBeNull: String by Delegates.notNull()
        println(shouldNotBeNull)
    }
}