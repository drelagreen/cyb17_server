package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.StationData

class StationDataRepo() {
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

    companion object {
        private var instance: StationDataRepo? = null

        fun getInstance(): StationDataRepo {
            if (instance == null) {
                instance = StationDataRepo()
            }

            BDLoader.loadStationsData().forEach {
                instance!!.addStation(it)
            }

            return instance!!
        }
    }
}