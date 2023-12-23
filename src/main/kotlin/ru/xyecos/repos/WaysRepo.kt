package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.Way

class WaysRepo {
    private val data: MutableList<Way> = mutableListOf()

    fun getAll(): List<Way> {
        return data
    }

    fun get(id: Int): Way? {
        return data.find { it.id == id }
    }

    fun add(way: Way) {
        data.add(way)
    }

    fun update(way: Way) {
        val index = data.indexOfFirst { it.id == way.id }
        data[index] = way
    }

    fun delete(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: WaysRepo? = null

        fun getInstance(): WaysRepo {
            if (instance == null) {
                instance = WaysRepo()

                val stationsData = BDLoader.loadStationsData()

                val ways = stationsData.map {
                    it.way
                }.distinct()

                ways.forEach { way ->
                    val park = stationsData.find {
                        it.way.id == way.id
                    }?.park

                    val station = stationsData.find {
                        it.way.id == way.id
                    }

                    val locomotives = stationsData.filter {
                        it.way.id == way.id
                    }.flatMap {
                        it.locomotives
                    }.distinct().map {
                        Way.Locomotive(
                            id = it.id,
                            inventoryNumber = it.inventoryNumber,
                            direction = Way.Locomotive.Direction.valueOf(it.direction),
                        )
                    }

                    val wagons = stationsData.filter {
                        it.way.id == way.id
                    }.flatMap {
                        it.wagons
                    }.distinct().map { wagon ->
                        wagon.id
                    }

                    instance!!.add(
                        Way(
                            id = way.id,
                            name = way.name,
                            parkId = park?.id ?: 0,
                            stationId = station?.station?.id ?: 0,
                            locomotives = locomotives,
                            wagonsCount = wagons.size,
                            wagonsIds = wagons,
                            maxCarriagesCount = station?.maxCarriagesCount ?: 0,
                        )
                    )
                }
            }
            return instance!!

        }
    }
}