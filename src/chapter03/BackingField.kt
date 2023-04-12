package chapter03

class BackingField {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = BackingField()
            t.sayHello()
        }
    }

    fun sayHello(){
        val boom = Boom(10)
        println(boom.priority)
        println(boom)
        val boom2 = boom.copy()
    }


    data class Boom(val _priority: Int = DEFAULT_PRIORITY) {
        companion object {
            const val MIN_PRIORITY = 1
            const val MAX_PRIORITY = 5
            const val DEFAULT_PRIORITY = 3
        }

        val isLowPriority
            get() = priority < 3

        var priority = validPriority(_priority)
            set(value) {
                field = validPriority(value)
            }

        private fun validPriority(p: Int) = p.coerceIn(MIN_PRIORITY, MAX_PRIORITY)

    }


}