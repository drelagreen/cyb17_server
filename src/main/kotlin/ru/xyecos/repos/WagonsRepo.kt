package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.Wagon

class WagonsRepo {
    private val data: MutableList<Wagon> = mutableListOf()

    fun getAll(): List<Wagon> {
        return data
    }

    fun get(id: Int): Wagon? {
        return data.find { it.id == id }
    }

    fun add(wagon: Wagon) {
        data.add(wagon)
    }

    fun update(wagon: Wagon) {
        val index = data.indexOfFirst { it.id == wagon.id }
        data[index] = wagon
    }

    fun delete(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: WagonsRepo? = null

        fun getInstance(): WagonsRepo {
            if (instance == null) {
                instance = WagonsRepo()

                val stationsData = BDLoader.loadStationsData()

                val wagons = stationsData.flatMap {
                    it.wagons
                }.distinct()


                wagons.forEach { wagon ->
                    val stationData = stationsData.find {
                        it.wagons.contains(wagon)
                    }

                    instance!!.add(
                        Wagon(
                            id = wagon.id,
                            inventoryNumber = wagon.inventoryNumber,
                            position = wagon.position,
                            type = wagon.type,
                            isSick = wagon.isSick,
                            cargo = wagon.cargo,
                            operationState = wagon.operationState,
                            idleDaysLength = wagon.idleDaysLength,
                            owner = wagon.owner,
                            isWithHatch = wagon.isWithHatch,
                            loadCapacity = wagon.loadCapacity,
                            daysToRepair = wagon.daysToRepair,
                            kilometersLeft = wagon.kilometersLeft,
                            isDirty = wagon.isDirty,
                            note1 = wagon.note1,
                            note2 = wagon.note2,
                            parkId = stationData?.park?.id ?: 0,
                            stationId = stationData?.station?.id ?: 0,
                            wayId = stationData?.way?.id ?: 0
                        )
                    )
                }

            }

            return instance!!
        }
    }
}