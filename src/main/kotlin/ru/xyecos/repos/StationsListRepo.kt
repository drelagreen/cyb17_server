package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.Station

class StationsListRepo {
    private val data: MutableList<Station> = mutableListOf()

    fun getStations(): List<Station> {
        return data
    }

    fun getStation(id: Int): Station? {
        return data.find { it.id == id }
    }

    fun addStation(station: Station) {
        data.add(station)
    }

    fun updateStation(station: Station) {
        val index = data.indexOfFirst { it.id == station.id }
        data[index] = station
    }

    fun deleteStation(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: StationsListRepo? = null

        fun getInstance(): StationsListRepo {
            if (instance == null) {
                instance = StationsListRepo()
            }

            BDLoader.loadStationsList().forEach {
                instance!!.addStation(it)
            }

            return instance!!
        }
    }
}