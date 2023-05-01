package question10

import java.io.File
import java.net.URL
import java.util.stream.IntStream
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class Miscellaneous {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Miscellaneous()
            t.sayHello()
        }
    }

    fun sayHello() {
        boom01()
        boom02()
        boom03()
        boom04()
        boom05()
        boom06()
    }
    fun boom01() {
        println("The current Kotlin version is ${KotlinVersion.CURRENT}")
    }
    fun boom02() {
        repeat(5) {
            println("Counting: $it")
        }
    }
    fun boom03() {
        val request = AstroRequest()
        val result: String = request()
        println(result)
    }


    class AstroRequest {
        companion object {
            private const val ASTRO_URL =
                "http://api.open-notify.org/astros.json"
        }
        // fun execute(): AstroResult {
        operator fun invoke(): String {
            return URL(ASTRO_URL).readText()
        }
    }

    fun doubleIt(x: Int): Int {
        Thread.sleep(100L)
        println("doubling $x with on thread ${Thread.currentThread().name}")
        return x * 2
    }

    fun boom04() {
        println("${Runtime.getRuntime().availableProcessors()} processors")
        var time = measureTimeMillis {
            IntStream.rangeClosed(1, 6)
                .map { doubleIt(it) }
                .sum()
        }
        println("Sequential stream took ${time}ms")
        time = measureTimeMillis {
            IntStream.rangeClosed(1, 6)
                .parallel()
                .map { doubleIt(it) }
                .sum()
        }
        println("Parallel stream took ${time}ms")
    }

    fun boom05() {
        (0..5).forEach { n ->
            val longRange = 1L..100L
            val sleepTime = longRange.random()
//            thread(isDaemon = true) {
            thread {
                Thread.sleep(sleepTime)
                println("${Thread.currentThread().name} for $n after ${sleepTime}ms")
            } //.join()
        }
    }

    fun boom06() {
        // TODO: I want to throw an exception
        TODO(reason = "none really")
    }
}