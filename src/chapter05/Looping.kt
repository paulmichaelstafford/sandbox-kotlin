package chapter05

import java.time.LocalDate

class Looping {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val t = Looping()
            t.sayHello()
        }
    }

    data class Player(val name: String)

    class Team(val name: String,
               val players: MutableList<Player> = mutableListOf()) : Iterable<Player> {
        fun addPlayers(vararg people: Player) =
            players.addAll(people)

        override fun iterator(): Iterator<Player> =
            players.iterator()
    }

    val team = Team("Warriors")

    fun sayHello() {
        team.addPlayers(Player("Curry"), Player("Thompson"),
            Player("Durant"), Player("Green"), Player("Cousins"))
        loop()
        loopAgain()
        andAgain()
        listByType()
    }

    fun loop() {
        for (player in team.players) {
            println(player)
        }
    }

    fun loopAgain() {
        operator fun Team.iterator() : Iterator<Player> = players.iterator()
        for (player in team) {
            println(player)
        }
    }

    fun andAgain() {
        for (player in team.iterator()) {
            println(player)
        }
    }

    fun listByType() {
        val list = listOf("a", LocalDate.now(), 3, 1, 4, "basd")
        val strings = list.filter { it is String }
        for (s in strings) {
            // s.length // does not compile; type is erased
        }

        val test = list.filterIsInstance<String>()
        for (tests in test) {
            println(tests.length)
        }
    }

}