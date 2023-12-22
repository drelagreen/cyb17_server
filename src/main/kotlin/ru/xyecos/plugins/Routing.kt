package ru.xyecos.plugins

import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.xyecos.domain.responses.Station
import ru.xyecos.domain.responses.StationShort
import ru.xyecos.repos.StationDataRepo
import ru.xyecos.repos.StationsListRepo

fun Application.configureRouting() {
    val gson = Gson()

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
                    ru.xyecos.domain.responses.Park(
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
                    ru.xyecos.domain.responses.Way(
                        id = id,
                        parkId = stationsList.firstOrNull()?.park?.id ?: 0,
                        name = stationsList.firstOrNull()?.way?.name ?: "",
                        locomotives = locomotives.map {
                            ru.xyecos.domain.responses.Way.Locomotive(
                                id = it.id,
                                inventoryNumber = it.inventoryNumber,
                                direction = ru.xyecos.domain.responses.Way.Locomotive.Direction.valueOf(it.direction)
                            )
                        },
                        wagonsCount = wagons.size,
                        wagonsIds = wagons.map {
                            it.id
                        },
                        maxCarriagesCount = stationsList.firstOrNull()?.maxCarriagesCount ?: 0
                    )
                )
            )
        }
    }
}

