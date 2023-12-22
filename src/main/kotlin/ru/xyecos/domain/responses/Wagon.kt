package ru.xyecos.domain.responses

data class Wagon (
    val id: Int,
    val inventoryNumber: String,
    val position: Int,
    val type: String,
    val isSick: Boolean,
    val cargo: String,
    val operationState: String,
    val idleDaysLength: Int,
    val owner: String,
    val isWithHatch: Boolean,
    val loadCapacity: Double,
    val daysToRepair: Int,
    val kilometersLeft: Int,
    val isDirty: Boolean,
    val note1: String,
    val note2: String
)