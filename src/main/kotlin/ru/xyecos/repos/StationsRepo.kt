package ru.xyecos.repos

import ru.xyecos.domain.StationData

class StationsRepo() {
    private val data: MutableList<StationData> = mutableListOf()

    fun getStations(): List<StationData> {
        return data
    }

    fun getStation(id: Int): StationData? {
        return data.find { it.station.id == id }
    }

    fun addStation(station: StationData) {
        data.add(station)
    }

    fun updateStation(station: StationData) {
        val index = data.indexOfFirst { it.station.id == station.station.id }
        data[index] = station
    }

    fun deleteStation(id: Int) {
        data.removeIf { it.station.id == id }
    }

    fun deleteAll() {
        data.clear()
    }
}