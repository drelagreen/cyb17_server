package ru.xyecos.repos

import io.ktor.server.application.*
import io.ktor.server.response.*
import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.Station
import ru.xyecos.domain.StationShort

class StationsRepo {
    private val data: MutableList<Station> = mutableListOf()

    fun getAll(): List<Station> {
        return data
    }

    fun get(id: Int): Station? {
        return data.find { it.id == id }
    }

    fun add(station: Station) {
        if (data.find { it.id == station.id } != null) return
        data.add(station)
    }

    fun update(station: Station) {
        val index = data.indexOfFirst { it.id == station.id }
        data[index] = station
    }

    fun delete(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: StationsRepo? = null

        fun getInstance(): StationsRepo {
            if (instance == null) {
                instance = StationsRepo()

                val stationsData = BDLoader.loadStationsData()

                val stationsIds = stationsData.map {
                    it.station.id
                }.distinct()

                stationsIds.forEach { id ->
                    val stationsList = stationsData.filter {
                        it.station.id == id
                    }.distinct()

                    val stationShort = BDLoader.loadStationsList().map {
                        StationShort(it.id, it.title, it.isLoginStation)
                    }.find {
                        it.id == id
                    }

                    val parks = stationsList.map {
                        it.park
                    }.distinct()

                    instance!!.add(
                        Station(
                            id = id,
                            title = stationsList.firstOrNull()?.station?.name ?: "",
                            isLoginStation = stationShort?.isLoginStation ?: false,
                            parksCount = parks.size,
                            parksIds = parks.map {
                                it.id
                            }
                        )
                    )
                }
            }
            return instance!!
        }
    }
}