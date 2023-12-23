package ru.xyecos.repos

import ru.xyecos.domain.forms.FormReviewResult
import ru.xyecos.domain.forms.LocomotiveMove
import ru.xyecos.domain.forms.WagonMove

class FormsArchive {
    private val wagonMoveForms: MutableMap<Int, WagonMove> = mutableMapOf()
    private val locomotiveMoveForms: MutableMap<Int, LocomotiveMove> = mutableMapOf()
    private val reviewResults: MutableMap<Int, FormReviewResult> = mutableMapOf()


    fun getReviewResult(id: Int): FormReviewResult? {
        return reviewResults[id]
    }

    fun saveReviewResult(result: FormReviewResult) {
        reviewResults[result.formId] = result
    }

    fun getWagonMoveForm(id: Int): WagonMove? {
        return wagonMoveForms[id]
    }

    fun saveWagonMoveForm(form: WagonMove) {
        wagonMoveForms[form.formId!!] = form
    }

    fun getLocomotiveMoveForm(id: Int): LocomotiveMove? {
        return locomotiveMoveForms[id]
    }

    fun saveLocomotiveMoveForm(form: LocomotiveMove) {
        locomotiveMoveForms[form.formId] = form
    }

    companion object {
        val instance = FormsArchive()
    }
}