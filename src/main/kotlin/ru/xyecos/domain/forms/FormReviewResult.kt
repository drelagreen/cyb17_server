package ru.xyecos.domain.forms

data class FormReviewResult(
    val formId: Int,
    val accepted: Boolean,
    val reviewerId: Int,
    val comment: String,
    val timestamp: Long
)