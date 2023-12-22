package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.OperationsTypes

class OperationsTypesRepo {
private val data: MutableList<OperationsTypes> = mutableListOf()

    fun getOperationsTimes(): List<OperationsTypes> {
        return data
    }

    fun getOperationsTimes(id: Int): OperationsTypes? {
        return data.find { it.id == id }
    }

    fun addOperationsTimes(operationsTimes: OperationsTypes) {
        data.add(operationsTimes)
    }

    fun updateOperationsTimes(operationsTimes: OperationsTypes) {
        val index = data.indexOfFirst { it.id == operationsTimes.id }
        data[index] = operationsTimes
    }

    fun deleteOperationsTimes(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: OperationsTypesRepo? = null

        fun getInstance(): OperationsTypesRepo {
            if (instance == null) {
                instance = OperationsTypesRepo()

                BDLoader.loadOperationTypes().forEach {
                    instance!!.addOperationsTimes(it)
                }
            }
            return instance!!
        }
    }
}