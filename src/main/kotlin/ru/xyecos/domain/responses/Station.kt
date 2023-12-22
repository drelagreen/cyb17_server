package ru.xyecos.domain.responses

data class Station(
    val id: Int,
    val title: String,
    val isLoginStation: Boolean,
    val parksCount: Int,
    val parksIds: List<Int>,
)