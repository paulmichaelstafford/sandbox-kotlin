package chapter08

import kotlin.properties.Delegates

class Observable {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Observable()
            t.sayHello()
        }
    }

    fun sayHello() {
        boom()
        boom1()
    }
    fun boom() {
        var watched: Int by Delegates.observable(1) { prop, old, new ->
            println("${prop.name} changed from $old to $new")
        }
        var checked: Int by Delegates.vetoable(0) { prop, old, new ->
            println("Trying to change ${prop.name} from $old to $new")
            new == -1
        }
        watched = 4
        checked = 100
        println(checked)
    }
    fun boom1() {
        var checked: Int? by Delegates.vetoable(null) { prop, old, new ->
            println("Trying to change ${prop.name} from $old to $new")
            old.toString() == "asd"
        }
        checked = 100
        println(checked)
    }
}