package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.WagonOwner
import java.util.UUID

class WagonOwnersRepo {
    private val data: MutableList<WagonOwner> = mutableListOf()

    fun getWagonOwners(): List<WagonOwner> {
        return data
    }

    fun getWagonOwner(id: UUID): WagonOwner? {
        return data.find { it.id == id }
    }

    fun addWagonOwner(wagonOwner: WagonOwner) {
        data.add(wagonOwner)
    }

    fun updateWagonOwner(wagonOwner: WagonOwner) {
        val index = data.indexOfFirst { it.id == wagonOwner.id }
        data[index] = wagonOwner
    }

    fun deleteWagonOwner(id: UUID) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: WagonOwnersRepo? = null

        fun getInstance(): WagonOwnersRepo {
            if (instance == null) {
                instance = WagonOwnersRepo()
            }

            BDLoader.loadOwnersList().owners.forEach {
                instance!!.addWagonOwner(WagonOwner(UUID.randomUUID(),it))
            }

            return instance!!
        }
    }
}