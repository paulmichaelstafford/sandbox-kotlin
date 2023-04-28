package question01

import kotlin.properties.Delegates

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(StatisticsService().getTop5())
    }
}

private class StatisticsService {
    // TODO: get the most sold 5 articles among all warehouses
    // TODO: get the most sold 5 articles of a warehouse

    fun getTop5(): List<Score> {
        val articleCounter = mutableMapOf<String, Int>()
        for(order in OrderProvider().loadPastOrders()) {
            for(article in order.articles) {
                articleCounter.putIfAbsent(article, 0)
                articleCounter[article] = articleCounter[article]!! + 1
            }
        }

        val scores = mutableListOf<Score>()
        for ((k, v) in articleCounter) {
            scores.add(Score(k, v))
        }

        return scores.sortedBy {
            it.score * -1
        }.take(5)
    }
}

data class Score(val article: String, val score: Int)

private class OrderProvider {
    fun loadPastOrders() = LocalDataSetProvider.localOrderDataSet()
}

private class OrderService {
    fun findOrderWarehouse(orderId: String) = LocalDataSetProvider.localOrderToWarehouseMapping()[orderId]
}

private data class WarehouseItem(
    val id: String,
    val article: String,
    val location: Location,
    val warehouseEntity: WarehouseEntity
)

private enum class Location {
    HALL_1, HALL_2, HALL_3
}

private data class CustomerOrder(
    val orderId: String,
    val client: String,
    val deliveryCountry: String,
    val articles: List<String>
)

private enum class WarehouseEntity {
    BERLIN, PARIS, MILAN
}

/*
 * --------------------------------------------------------------
 * ---------------------- TEST DATA SET -------------------------
 * --------------------------------------------------------------
 */
private object LocalDataSetProvider {
    fun localItemDataSet(): List<WarehouseItem> =
        listOf(
            WarehouseItem("item-id-1", "article-1", Location.HALL_1, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-2", "article-2", Location.HALL_1, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-3", "article-3", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-4", "article-4", Location.HALL_3, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-5", "article-5", Location.HALL_1, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-6", "article-5", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-7", "article-6", Location.HALL_3, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-8", "article-6", Location.HALL_3, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-9", "article-7", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-10", "article-7", Location.HALL_3, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-11", "article-7", Location.HALL_1, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-12", "article-8", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-13", "article-8", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-14", "article-8", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-15", "article-8", Location.HALL_3, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-16", "article-9", Location.HALL_1, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-17", "article-9", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-18", "article-9", Location.HALL_3, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-19", "article-9", Location.HALL_2, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-20", "article-9", Location.HALL_1, WarehouseEntity.BERLIN),
            WarehouseItem("item-id-21", "article-1", Location.HALL_1, WarehouseEntity.PARIS),
            WarehouseItem("item-id-22", "article-1", Location.HALL_1, WarehouseEntity.PARIS),
            WarehouseItem("item-id-23", "article-1", Location.HALL_2, WarehouseEntity.PARIS),
            WarehouseItem("item-id-24", "article-2", Location.HALL_3, WarehouseEntity.PARIS),
            WarehouseItem("item-id-25", "article-2", Location.HALL_1, WarehouseEntity.PARIS),
            WarehouseItem("item-id-26", "article-3", Location.HALL_2, WarehouseEntity.PARIS),
            WarehouseItem("item-id-27", "article-4", Location.HALL_3, WarehouseEntity.PARIS),
            WarehouseItem("item-id-28", "article-5", Location.HALL_3, WarehouseEntity.PARIS),
            WarehouseItem("item-id-29", "article-6", Location.HALL_2, WarehouseEntity.PARIS),
            WarehouseItem("item-id-30", "article-7", Location.HALL_3, WarehouseEntity.PARIS)
        )

    fun localOrderDataSet(): List<CustomerOrder> {
        val articles1 = listOf("article-5", "article-9-top-worldwide", "article-8")
        val order1 = CustomerOrder("order-1", "client-1", "DE", articles1)

        val articles2 = listOf("article-1", "article-9-top-worldwide", "article-6")
        val order2 = CustomerOrder("order-2", "client-2", "DE", articles2)

        val articles3 = listOf(
            "article-5",
            "article-5",
            "article-5",
            "article-4",
            "article-4",
            "article-3",
            "article-2",
            "article-2"
        )
        val order3 = CustomerOrder("order-3", "client-3", "DE", articles3)

        val articles4 = listOf(
            "article-7-top-berlin",
            "article-7-top-berlin",
            "article-7-top-berlin",
            "article-7-top-berlin",
            "article-7-top-berlin",
            "article-7-top-berlin",
            "article-7-top-berlin",
            "article-4"
        )
        val order4 = CustomerOrder("order-4", "client-4", "DE", articles4)

        val articles5 = listOf("article-9-top-worldwide", "article-9-top-worldwide")
        val order5 = CustomerOrder("order-5", "client-5", "DE", articles5)

        val articles6 = listOf(
            "article-6",
            "article-6",
            "article-6",
            "article-8",
            "article-3",
            "article-9-top-worldwide",
            "article-9-top-worldwide",
            "article-9-top-worldwide",
            "article-9-top-worldwide"
        )
        val order6 = CustomerOrder("order-6", "client-6", "FR", articles6)

        val articles7 = listOf(
            "article-5",
            "article-9-top-worldwide",
            "article-8",
            "article-8",
            "article-8",
            "article-8",
            "article-8",
            "article-8",
            "article-6",
            "article-6",
            "article-3",
            "article-4",
        )
        val order7 = CustomerOrder("order-7", "client-7", "FR", articles7)
        return listOf(order1, order2, order3, order4, order5, order6, order7)
    }

    fun localOrderToWarehouseMapping(): Map<String, WarehouseEntity> =
        mapOf(
            "order-1" to WarehouseEntity.BERLIN,
            "order-2" to WarehouseEntity.BERLIN,
            "order-3" to WarehouseEntity.BERLIN,
            "order-4" to WarehouseEntity.BERLIN,
            "order-5" to WarehouseEntity.BERLIN,
            "order-6" to WarehouseEntity.PARIS,
            "order-7" to WarehouseEntity.PARIS
        )
}