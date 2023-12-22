package ru.xyecos.repos

import ru.xyecos.domain.forms.WagonMove

class FormsArchive {
    private val wagonMoveForms: MutableMap<Int, WagonMove> = mutableMapOf()

    fun getWagonMoveForm(id: Int): WagonMove? {
        return wagonMoveForms[id]
    }

    fun saveWagonMoveForm(form: WagonMove) {
        wagonMoveForms[form.formId] = form
    }

    companion object {
        val instance = FormsArchive()
    }
}