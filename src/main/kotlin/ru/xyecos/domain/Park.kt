package ru.xyecos.domain

data class Park(
    val id: Int,
    val stationId: Int,
    val name: String,
    val waysCount: Int,
    val waysIds: List<Int>,
)