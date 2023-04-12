package chapter03

class BackingProblem {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = BackingProblem()
            t.sayHello()
        }
    }

    fun sayHello(){
        val customer = Customer("Fred").apply { messages }
        println(customer.messages.size)
    }


    class Customer(val name: String) {
        private var _messages: List<String>? = null
        val messages: List<String>
            get() {
                if (_messages == null) {
                    _messages = loadMessages()
                }
                return _messages!!
            }
        private fun loadMessages(): MutableList<String> =
                mutableListOf(
                        "Initial contact",
                        "Convinced them to use Kotlin",
                        "Sold training class. Sweet.").also { println("Loaded messages") }
    }
}