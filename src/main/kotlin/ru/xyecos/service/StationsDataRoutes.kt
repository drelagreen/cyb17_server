package ru.xyecos.service

import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.xyecos.domain.*
import ru.xyecos.domain.responses.*
import ru.xyecos.repos.*

/**
 * Тут мы инициализируем список станций из БД, храним списки станций,
 * CRUD методы для станций, общие логические методы для станций
 */

fun Routing.stationsDataRoutes(gson: Gson) {
    get("/") {
        call.respondText("API For Railway Stations System")
    }

    //список станций
    get("/stations") {
        call.respondText(
            gson.toJson(
                StationsRepo.getInstance().getAll()
            )
        )
    }

    get("/stations/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val station = StationsRepo.getInstance().get(id)

        if (station == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        call.respondText(
            gson.toJson(
                station
            )
        )
    }

    get("park/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val park = ParksRepo.getInstance().get(id)

        if (park == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        call.respondText(
            gson.toJson(
                park
            )
        )
    }

    get("way/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val way = WaysRepo.getInstance().get(id)

        if (way == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        call.respondText(
            gson.toJson(
                way
            )
        )
    }

    get("wagon/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val wagon = WagonsRepo.getInstance().get(id)

        if (wagon == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        call.respondText(
            gson.toJson(
                wagon
            )
        )
    }
}
