package ru.xyecos.repos

import ru.xyecos.domain.Wagon
import ru.xyecos.domain.Way

class ShadowMergeRepo {
    private val virtualWaysDep: MutableMap<Int, Way> = mutableMapOf()
    private val virtualWaysDest: MutableMap<Int, Way> = mutableMapOf()
    private val virtualWagons: MutableMap<Int, List<Wagon>> = mutableMapOf()
    private val shadowMergeIds: MutableMap<Int, Array<Int>> = mutableMapOf()

    fun saveShadowMergeId(
        id: Int,
        virtualWayDep: Int,
        virtualWayDest: Int,
    ) {
        shadowMergeIds[id] = arrayOf(virtualWayDep, virtualWayDest)
    }

    fun getShadowMerge(id: Int): Pair<Array<Int>, List<Wagon>>? {
        return shadowMergeIds[id]?.let {
            Pair(it, virtualWagons[id] ?: listOf())
        }
    }

    fun addVirtualWayDep(way: Way) {
        virtualWaysDep[way.id] = way
    }

    fun addVirtualWayDest(way: Way) {
        virtualWaysDest[way.id] = way
    }

    fun addVirtualWagon(formId: Int, wagon: Wagon) {
        virtualWagons[formId] = virtualWagons[formId]?.plus(wagon) ?: listOf(wagon)
    }

    fun getVirtualWayDest(id: Int): Way? {
        return virtualWaysDest[id]
    }

    fun getVirtualWayDep(id: Int): Way? {
        return virtualWaysDep[id]
    }

    fun getVirtualWagons(formId: Int): List<Wagon>? {
        return virtualWagons[formId]
    }

    fun cleanByShadowMergeId(id: Int) {
        shadowMergeIds[id].apply {
            virtualWaysDep.remove(this!![0])
            virtualWaysDest.remove(this[1])
            virtualWagons.remove(id)
        }
    }

    companion object {
        val instance = ShadowMergeRepo()
    }
}