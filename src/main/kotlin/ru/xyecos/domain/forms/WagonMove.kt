package ru.xyecos.domain.forms

data class WagonMove(
    val timestamp: Long,
    val formId: Int,

    val departureStation: Int,
    val departurePark: Int,
    val departureWay: Int,

    val destinationStation: Int,
    val destinationPark: Int,
    val destinationWay: Int,

    val locomotives: List<Int>,
    val wagons: List<Int>,

    val comment: String,
    val operationInitiator: String,
    val reasonId: Int,
    val needAcceptance: Boolean,

    val deviationMinutes: String
)