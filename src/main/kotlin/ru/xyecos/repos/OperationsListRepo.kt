package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.OperationsList

class OperationsListRepo {
private val data: MutableList<OperationsList> = mutableListOf()

    fun getOperations(): List<OperationsList> {
        return data
    }

    fun getOperation(id: Int): OperationsList? {
        return data.find { it.operationId == id }
    }

    fun addOperation(operationsTimesNorms: OperationsList) {
        data.add(operationsTimesNorms)
    }

    fun updateOperation(operationsTimesNorms: OperationsList) {
        val index = data.indexOfFirst { it.operationId == operationsTimesNorms.operationId }
        data[index] = operationsTimesNorms
    }

    fun deleteOperation(id: Int) {
        data.removeIf { it.operationId == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: OperationsListRepo? = null

        fun getInstance(): OperationsListRepo {
            if (instance == null) {
                instance = OperationsListRepo()

                BDLoader.loadOperationsList().forEach {
                    instance!!.addOperation(it)
                }
            }
            return instance!!
        }
    }
}