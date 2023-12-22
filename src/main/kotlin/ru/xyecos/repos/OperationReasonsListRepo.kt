package ru.xyecos.repos

import ru.xyecos.bd.BDLoader
import ru.xyecos.domain.OperationReasonsList

class OperationReasonsListRepo {
    private val data: MutableList<OperationReasonsList> = mutableListOf()

    fun getOperationReasons(): List<OperationReasonsList> {
        return data
    }

    fun getOperationReasons(id: Int): OperationReasonsList? {
        return data.find { it.id == id }
    }

    fun addOperationReasons(operationReasons: OperationReasonsList) {
        data.add(operationReasons)
    }

    fun updateOperationReasons(operationReasons: OperationReasonsList) {
        val index = data.indexOfFirst { it.id == operationReasons.id }
        data[index] = operationReasons
    }

    fun deleteOperationReasons(id: Int) {
        data.removeIf { it.id == id }
    }

    fun deleteAll() {
        data.clear()
    }

    companion object {
        private var instance: OperationReasonsListRepo? = null

        fun getInstance(): OperationReasonsListRepo {
            if (instance == null) {
                instance = OperationReasonsListRepo()

                BDLoader.loadOperationReasonsList().forEach {
                    instance!!.addOperationReasons(it)
                }
            }
            return instance!!
        }
    }
}