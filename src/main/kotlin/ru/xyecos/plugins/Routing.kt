package ru.xyecos.plugins

import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.xyecos.domain.responses.*
import ru.xyecos.repos.StationDataRepo
import ru.xyecos.repos.StationsListRepo
import ru.xyecos.service.stationsDataRoutes

fun Application.configureRouting() {
    val gson = Gson()

    stationsDataRoutes(gson)

}

