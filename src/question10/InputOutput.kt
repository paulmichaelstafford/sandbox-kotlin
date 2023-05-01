package question10

import java.io.File
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class InputOutput {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = InputOutput()
            t.sayHello()
        }
    }

    fun sayHello() {
        boom()
    }
    fun boom() {

        val words = get10LongestWordsInDictionary()
        words.forEach{ word -> println("$word (${word.length})") }

    }
    fun get10LongestWordsInDictionary() =
        File("/usr/share/dict/words").useLines { line ->
            line.filter { it.length > 20 }
                .sortedByDescending(String::length)
                .take(10)
                .toList()
        }
}