package ru.xyecos.repos

import java.util.concurrent.atomic.AtomicInteger

class FormsStatusRepo {
    private val data: MutableMap<Int, Status> = mutableMapOf()

    @Volatile
    var currentID: AtomicInteger = AtomicInteger(1)

    fun getForms(): Map<Int, Status> = data

    @Synchronized
    fun generateFormId(): Int {
        val id = currentID.getAndIncrement()
        data[id] = Status.CREATION
        return id
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
    fun rejectForm(id: Int) {
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