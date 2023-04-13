package chapter08

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegateExample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = DelegateExample()
            t.sayHello()
        }
    }

    fun sayHello() {
        boom()
    }

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }

    class Example {
        var p: String by Delegate()
    }

    fun boom() {
        val e = Example()
        println(e.p)
        e.p = "ass"

    }
}