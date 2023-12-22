package ru.xyecos.plugins

import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.xyecos.domain.forms.WagonMove
import ru.xyecos.domain.responses.*
import ru.xyecos.domain.responses.form.FormCreated
import ru.xyecos.repos.FormsArchive
import ru.xyecos.repos.FormsStatusRepo
import ru.xyecos.repos.StationDataRepo
import ru.xyecos.repos.StationsListRepo
import ru.xyecos.service.stationsDataRoutes

fun Application.configureRouting() {
    val gson = Gson()
    routing {
        stationsDataRoutes(gson)
        wagonsFunctions(gson)
    }

}

fun Routing.wagonsFunctions(gson: Gson) {
    get("/fun/createForm") {
        FormsStatusRepo.instance.generateFormId()
        call.respondText(
            gson.toJson(
                FormCreated(FormsStatusRepo.instance.generateFormId())
            )
        )
    }

    post("/fun/wagonMove") {
        val form = call.receiveNullable<WagonMove>()

        if (form == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        FormsStatusRepo.instance.openForm(form.formId)

        FormsArchive.instance.saveWagonMoveForm(form)

        call.respond(HttpStatusCode.OK)
    }

    post("/fun/") {

    }
}

