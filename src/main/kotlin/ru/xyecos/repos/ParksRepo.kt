package ru.xyecos.repos

import io.ktor.server.application.*
import io.ktor.server.response.*
import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.Park

class ParksRepo {
    private val data: MutableList<Park> = mutableListOf()

    fun getAll(): List<Park> {
        return data
    }

    fun get(id: Int): Park? {
        return data.find { it.id == id }
    }

    fun add(park: Park) {
        data.add(park)
    }

    fun update(park: Park) {
        val index = data.indexOfFirst { it.id == park.id }
        data[index] = park
    }

    fun delete(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: ParksRepo? = null

        fun getInstance(): ParksRepo {
            if (instance == null) {
                instance = ParksRepo()

                val stationsData = BDLoader.loadStationsData()

                val parkIds = stationsData.map {
                    it.park.id
                }.distinct()

                parkIds.forEach { id ->
                    val ways = stationsData.filter {
                        it.park.id == id
                    }.map {
                        it.way
                    }.distinct()

                    instance!!.add(
                        Park(
                            id = id,
                            name = stationsData.map {
                                it.park
                            }.find {
                                it.id == id
                            }?.name ?: "",
                            stationId = stationsData.map {
                                it.station
                            }.find {
                                it.id == id
                            }?.id ?: 0,
                            waysCount = ways.size,
                            waysIds = ways.map {
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