package ru.xyecos.plugins

import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.http.ContentDisposition.Companion.File
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.xyecos.domain.forms.FormReviewResult
import ru.xyecos.domain.forms.LocomotiveMove
import ru.xyecos.domain.forms.WagonMove
import ru.xyecos.domain.responses.form.FormCreated
import ru.xyecos.domain.responses.form.ShadowMergeResults
import ru.xyecos.repos.*
import ru.xyecos.service.*
import java.io.File
import java.util.*

fun Application.configureRouting() {
    val gson = Gson()
    routing {
        stationsDataRoutes(gson)
        wagonsFunctions(gson)
        locomotiveFunctions(gson)
        staticFiles("/apidoc", File("/Users/dzhalnin/redoc-static.html"))
    }
}

