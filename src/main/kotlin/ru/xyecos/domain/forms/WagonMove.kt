package ru.xyecos.domain.forms

data class WagonMove(
    val timestamp: Long? = null,
    val formId: Int? = null,

    val departureStation: Int? = null,
    val departurePark: Int? = null,
    val departureWay: Int? = null,

    val destinationStation: Int? = null,
    val destinationPark: Int? = null,
    val destinationWay: Int? = null,

    val locomotives: List<Int>? = null,
    val wagons: List<Int>? = null,

    val comment: String? = null,
    val operationInitiator: String? = null,
    val reasonId: Int? = null,
    val needAcceptance: Boolean? = null,
)