package ru.xyecos.repos

import java.util.concurrent.atomic.AtomicInteger

class FormsStatusRepo {
    val data: MutableMap<Int, Status> = mutableMapOf()

    @Volatile
    var currentID: AtomicInteger = AtomicInteger(1)

    @Synchronized
    fun generateFormId(): Int {
        return currentID.getAndIncrement()
    }
    @Synchronized
    fun openForm(id: Int) {
        data[id] = Status.OPEN
    }
    @Synchronized
    fun acceptForm(id: Int) {
        data[id] = Status.ACCEPTED
    }
    @Synchronized
    fun declineForm(id: Int) {
        data[id] = Status.DECLINED
    }

    @Synchronized
    fun getStatus(id: Int): Status {
        return data[id] ?: Status.NONE
    }

    enum class Status {
        CREATION,
        OPEN,
        ACCEPTED,
        DECLINED,
        NONE
    }

    companion object {
        val instance = FormsStatusRepo()
    }
}