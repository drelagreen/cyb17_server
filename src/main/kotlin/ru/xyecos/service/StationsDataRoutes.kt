package ru.xyecos.service

import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.xyecos.domain.responses.*
import ru.xyecos.repos.StationDataRepo
import ru.xyecos.repos.StationsListRepo

/**
 * Тут мы инициализируем список станций из БД, храним списки станций,
 * CRUD методы для станций, общие логические методы для станций
 */
fun Application.stationsDataRoutes(gson: Gson) {
    routing {
        get("/") {
            call.respondText("Hello World!")

            StationDataRepo.getInstance().getStations().apply {
                println(this)
            }
        }

        //список вагонов

        //список станций
        get("/stations") {
            call.respondText(
                gson.toJson(
                    StationsListRepo.getInstance().getStations().map {
                        StationShort(it.id, it.title, it.isLoginStation)
                    }
                )
            )
        }

        get("/stations/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val stationsList = StationDataRepo.getInstance().getStations().filter {
                it.station.id == id
            }

            val stationShort = StationsListRepo.getInstance().getStations().map {
                StationShort(it.id, it.title, it.isLoginStation)
            }.find {
                it.id == id
            }

            val parks = stationsList.map {
                it.park
            }.distinct()

            call.respondText(
                gson.toJson(
                    Station(
                        id = id,
                        title = stationsList.firstOrNull()?.station?.name ?: "",
                        isLoginStation = stationShort?.isLoginStation ?: false,
                        parksCount = parks.size,
                        parksIds = parks.map {
                            it.id
                        }
                    )
                )
            )
        }

        get("park/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val stationsList = StationDataRepo.getInstance().getStations().filter {
                it.park.id == id
            }

            val ways = stationsList.map {
                it.way
            }.distinct()

            call.respondText(
                gson.toJson(
                    Park(
                        id = id,
                        stationId = stationsList.firstOrNull()?.station?.id ?: 0,
                        name = stationsList.firstOrNull()?.park?.name ?: "",
                        waysCount = ways.size,
                        waysIds = ways.map {
                            it.id
                        }
                    )
                )
            )
        }

        get("way/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val stationsList = StationDataRepo.getInstance().getStations().filter {
                it.way.id == id
            }

            val locomotives = stationsList.flatMap {
                it.locomotives
            }.distinct()

            val wagons = stationsList.flatMap {
                it.wagons
            }.distinct()

            call.respondText(
                gson.toJson(
                    Way(
                        id = id,
                        parkId = stationsList.firstOrNull()?.park?.id ?: 0,
                        name = stationsList.firstOrNull()?.way?.name ?: "",
                        locomotives = locomotives.map {
                            Way.Locomotive(
                                id = it.id,
                                inventoryNumber = it.inventoryNumber,
                                direction = Way.Locomotive.Direction.valueOf(it.direction)
                            )
                        },
                        wagonsCount = wagons.size,
                        wagonsIds = wagons.map {
                            it.id
                        },
                        maxCarriagesCount = stationsList.firstOrNull()?.maxCarriagesCount ?: 0,
                        stationId = stationsList.firstOrNull()?.station?.id ?: 0
                    )
                )
            )
        }

        get("wagon/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val stationData = StationDataRepo.getInstance().getStations().find {
                it.wagons.any {
                    it.id == id
                }
            }

            val wagon = StationDataRepo.getInstance().getStations().flatMap {
                it.wagons
            }.find {
                it.id == id
            }

            if (wagon == null) {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }

            call.respondText(
                gson.toJson(
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
            )
        }
    }
}
