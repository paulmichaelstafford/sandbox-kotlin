package chapter05

import java.time.LocalDate

class RangeAgain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = RangeAgain()
            t.sayHello()
        }
    }

    fun sayHello() {
        chunked()
    }

    fun chunked() {
        val date1 = LocalDate.now()
        val date2 = date1.plusDays(3)
        val date3 = date1.plusDays(5)
        val dateRange = date1..date3
        println(date1.plusDays(1) in dateRange)

//        for (date in dateRange) println(it)
//        // compiler error!
//        (startDate..endDate).forEach { /* ... */ } // compiler error!

//        val dateRange1 = date1..date2 step 2
    }

    class LocalDateProgression(
        override val start: LocalDate,
        override val endInclusive: LocalDate,
        val step: Long = 1
    ) : Iterable<LocalDate>, ClosedRange<LocalDate> {
        override fun iterator(): Iterator<LocalDate> =
            LocalDateProgressionIterator(start, endInclusive, step)
        infix fun step(days: Long) = LocalDateProgression(start, endInclusive, days)
        operator fun LocalDate.rangeTo(other: LocalDate) =
            LocalDateProgression(this, other)
    }

    internal class LocalDateProgressionIterator(
        start: LocalDate,
        val endInclusive: LocalDate,
        val step: Long
    ) : Iterator<LocalDate> {
        private var current = start
        override fun hasNext() = current <= endInclusive
        override fun next(): LocalDate {
            val next = current
            current = current.plusDays(step)
            return next
        }
    }
}