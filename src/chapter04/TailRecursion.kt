import java.math.BigInteger

class TailRecursion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = TailRecursion()
            t.sayHello()
        }
    }

    fun sayHello(){
        println(recursiveFactorialTest(10_000))
        println("this first part works")
        print(recursiveFactorial(10_000))
    }

    fun recursiveFactorial(n: Long): BigInteger {
        return when (n) {
            0L, 1L -> BigInteger.ONE
            else -> BigInteger.valueOf(n) * recursiveFactorial(n - 1)
        }
    }

    /*
    To summarize, the requirements for a function to be eligible for the tailrec modifier
    are as follows:
    • The function must call itself as the last operation it performs.
    • You cannot use tailrec inside try/catch/finally blocks.
    • Tail recursion is supported only on the JVM backend.
     */

    @JvmOverloads
    tailrec fun recursiveFactorialTest(n: Long, acc: BigInteger = BigInteger.ONE): BigInteger {
        return when (n) {
            0L -> BigInteger.ONE
            1L -> acc
            else -> recursiveFactorialTest(n - 1, acc * BigInteger.valueOf(n))
        }
    }

}