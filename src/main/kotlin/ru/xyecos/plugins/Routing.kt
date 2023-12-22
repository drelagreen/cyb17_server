package ru.xyecos.plugins

import com.google.gson.Gson
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
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
        post("/stations") {
            call.respondText(
                gson.toJson(StationsListRepo.getInstance().getStations())
            )
        }

    }

}

