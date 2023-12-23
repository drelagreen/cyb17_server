package ru.xyecos.domain

data class Way(
    val id: Int,
    val parkId: Int,
    val stationId: Int,
    val name: String,
    val maxCarriagesCount: Int,
    val locomotives: List<Locomotive>,
    val wagonsCount: Int,
    val wagonsIds: List<Int>,
) {
    data class Locomotive(
        val id: Int,
        val inventoryNumber: String,
        val direction: Direction,
    ) {
        enum class Direction {
            LEFT,
            RIGHT,
        }
    }
}