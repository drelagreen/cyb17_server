package ru.xyecos.service

import ru.xyecos.domain.StationData

/**
 * Тут мы инициализируем список станций из БД, храним списки станций,
 * CRUD методы для станций, общие логические методы для станций
 */
class Stations {
    val stationsList: MutableList<StationData> = mutableListOf()

    fun loadStations() {

    }
}