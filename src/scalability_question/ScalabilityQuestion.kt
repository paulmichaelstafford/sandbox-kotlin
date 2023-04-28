package scalability_question

class ScalabilityQuestion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = ScalabilityQuestion()
            t.sayHello()
        }
    }

    fun sayHello() {
        println("hello")
    }
}