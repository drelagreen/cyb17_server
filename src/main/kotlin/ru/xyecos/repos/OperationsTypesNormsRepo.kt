package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.OperationsTypesNorms

class OperationsTypesNormsRepo {
    private val data: MutableList<OperationsTypesNorms> = mutableListOf()

    fun getOperationsTypesNorms(): List<OperationsTypesNorms> {
        return data
    }

    fun getOperationsTypesNorms(id: Int): OperationsTypesNorms? {
        return data.find { it.operationId == id }
    }

    fun addOperationsTypesNorms(operationsTimesNorms: OperationsTypesNorms) {
        data.add(operationsTimesNorms)
    }

    fun updateOperationsTypesNorms(operationsTimesNorms: OperationsTypesNorms) {
        val index = data.indexOfFirst { it.operationId == operationsTimesNorms.operationId }
        data[index] = operationsTimesNorms
    }

    fun deleteOperationsTypesNorms(id: Int) {
        data.removeIf { it.operationId == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: OperationsTypesNormsRepo? = null

        fun getInstance(): OperationsTypesNormsRepo {
            if (instance == null) {
                instance = OperationsTypesNormsRepo()

                BDLoader.loadOperationsTypesNorms().forEach {
                    instance!!.addOperationsTypesNorms(it)
                }
            }
            return instance!!
        }
    }
}