package chapter08

class CompositionByDelegation {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = CompositionByDelegation()
            t.sayHello()
        }
    }

    fun sayHello() {
        boom()
    }

    interface Dialable {
        fun dial(number: String): String
    }
    class Phone : Dialable {
        override fun dial(number: String) =
            "Dialing $number..."
    }
    interface Snappable {
        fun takePicture(): String
    }
    class Camera : Snappable {
        override fun takePicture() =
            "Taking picture..."
    }
    class SmartPhone(
        private val phone: Dialable = Phone(),
        private val camera: Snappable = Camera()
    ) : Dialable by phone, Snappable by camera
    fun boom() {
        val smartPhone = SmartPhone()
        println(smartPhone.dial("123"))
        println(smartPhone.takePicture())
    }
}