package ru.xyecos.domain.responses.form

import ru.xyecos.domain.Wagon
import ru.xyecos.domain.Way

data class ShadowMergeResults(
    val ways: List<Way>,
    val wagons: List<Wagon>
)