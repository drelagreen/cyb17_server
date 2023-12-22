package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.WagonType
import java.util.*

class WagonTypeList {
    private val data: MutableList<WagonType> = mutableListOf()

    fun getWagonTypes(): List<WagonType> {
        return data
    }

    fun getWagonType(id: UUID): WagonType? {
        return data.find { it.id == id }
    }

    fun addWagonType(wagonType: WagonType) {
        data.add(wagonType)
    }

    fun updateWagonType(wagonType: WagonType) {
        val index = data.indexOfFirst { it.id == wagonType.id }
        data[index] = wagonType
    }

    fun deleteWagonType(id: UUID) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: WagonTypeList? = null

        fun getInstance(): WagonTypeList {
            if (instance == null) {
                instance = WagonTypeList()
            }

            BDLoader.loadWagonTypeList().wagonTypes.forEach {
                instance!!.addWagonType(WagonType(UUID.randomUUID(), it))
            }

            return instance!!
        }
    }
}