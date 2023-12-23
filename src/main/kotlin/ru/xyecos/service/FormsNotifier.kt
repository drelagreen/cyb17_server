package ru.xyecos.service

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object FormsNotifier {
    private val _openedForms: MutableStateFlow<Set<Int>> = MutableStateFlow(emptySet())

    val openedForms: StateFlow<Set<Int>>
        get() = _openedForms

    fun notifyFormOpened(formId: Int) {
        _openedForms.tryEmit(openedForms.value + formId)
    }

    fun notifyFormClosed(formId: Int) {
        _openedForms.tryEmit(openedForms.value - formId)
    }
}