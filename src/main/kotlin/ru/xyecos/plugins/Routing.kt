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
import ru.xyecos.service.FormsNotifier
import ru.xyecos.service.ShadowMerger
import ru.xyecos.service.stationsDataRoutes
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

var o = 0

fun Routing.locomotiveFunctions(gson: Gson) {
    get("/test") {
        call.respondText(
            gson.toJson(
                WaysRepo.getInstance().getAll().map {
                    it.locomotives
                }.distinct()
            )
        )

        FormsNotifier.notifyFormOpened(o++)
    }

    post("/forms/locomotives/move") {
        val form = call.receiveNullable<LocomotiveMove>()

        if (form == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        FormsStatusRepo.instance.openForm(form.formId)

        FormsArchive.instance.saveLocomotiveMoveForm(form)
        FormsArchive.instance.saveReviewResult(
            FormReviewResult(
                form.formId,
                true,
                0,
                "Автоматическое подтверждение",
                Date().time
            )
        )

        FormsStatusRepo.instance.acceptForm(form.formId)

        call.respond(HttpStatusCode.OK)
    }
}

fun Routing.wagonsFunctions(gson: Gson) {
    get("/forms/createForm") {
        FormsStatusRepo.instance.generateFormId()
        call.respondText(
            gson.toJson(
                FormCreated(
                    FormsStatusRepo.instance.generateFormId(),
                    Date().time
                )
            )
        )
    }

    post("/forms/wagonMove") {
        val form = call.receiveNullable<WagonMove>()

        if (form == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        FormsStatusRepo.instance.openForm(form.formId!!)

        FormsArchive.instance.saveWagonMoveForm(form)

        FormsNotifier.notifyFormOpened(form.formId)

        call.respond(
            HttpStatusCode.OK
        )
    }

    post("/forms/formReview") {
        val formReviewResult = call.receiveNullable<FormReviewResult>()

        if (formReviewResult == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }

        if (formReviewResult.accepted) {
            FormsStatusRepo.instance.acceptForm(formReviewResult.formId)
            ShadowMergeRepo.instance.getShadowMerge(formReviewResult.formId)?.let {
                WaysRepo.getInstance().update(ShadowMergeRepo.instance.getVirtualWayDep(it.first[0])!!)
                WaysRepo.getInstance().update(ShadowMergeRepo.instance.getVirtualWayDest(it.first[1])!!)
                it.second.forEach { wagon ->
                    WagonsRepo.getInstance().update(wagon)
                }
                ShadowMergeRepo.instance.cleanByShadowMergeId(formReviewResult.formId)
            }
        } else {
            FormsStatusRepo.instance.rejectForm(formReviewResult.formId)
        }

        FormsArchive.instance.saveReviewResult(formReviewResult)

        FormsNotifier.notifyFormClosed(formReviewResult.formId)

        call.respond(HttpStatusCode.OK)
    }

    get("/forms") {
        call.respondText(
            gson.toJson(
                FormsStatusRepo.instance.getForms().filterNot {
                    it.value == FormsStatusRepo.Status.CREATION
                }
            )
        )
    }

    get("/forms/openedForms") {
        call.respondText(
            gson.toJson(
                FormsStatusRepo.instance.getForms().filter {
                    it.value == FormsStatusRepo.Status.OPEN
                }.keys
            )
        )
    }

    get("/forms/formStatus/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val status = FormsStatusRepo.instance.getStatus(id)

        call.respondText(
            gson.toJson(
                status
            )
        )
    }

    get("/forms/shadowMerge/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(HttpStatusCode.BadRequest)
            return@get
        }

        val form = FormsArchive.instance.getWagonMoveForm(id)
        val formReviewResult = FormsArchive.instance.getReviewResult(id)

        if (form == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        if (formReviewResult == null && ShadowMergeRepo.instance.getShadowMerge(id) == null) {
            ShadowMerger.mergeWagonMove(id)
        }

        val shadowMerge = ShadowMergeRepo.instance.getShadowMerge(id)
        if (shadowMerge == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        val wagons = ShadowMergeRepo.instance.getVirtualWagons(id)
        val wayDep = ShadowMergeRepo.instance.getVirtualWayDep(shadowMerge.first[0])
        val wayDest = ShadowMergeRepo.instance.getVirtualWayDest(shadowMerge.first[1])

        val newWays = WaysRepo.getInstance().getAll().map {
            when (it.id) {
                wayDep!!.id -> {
                    it.copy(
                        wagonsIds = wayDep.wagonsIds,
                    )
                }

                wayDest!!.id -> {
                    it.copy(
                        wagonsIds = wayDest.wagonsIds,
                    )
                }

                else -> {
                    it
                }
            }
        }

        val newWagons = WagonsRepo.getInstance().getAll().map { wagon ->
            wagons?.find { it.id == wagon.id } ?: wagon
        }

        call.respondText(
            gson.toJson(
                ShadowMergeResults(
                    ways = newWays,
                    wagons = newWagons
                )
            )
        )
    }
}

