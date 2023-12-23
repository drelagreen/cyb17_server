package ru.xyecos.service

import ru.xyecos.repos.*

object ShadowMerger {
    fun mergeWagonMove(formId: Int) {
        val form = FormsArchive.instance.getWagonMoveForm(formId) ?: return

        form.wagons.forEach {
            val wagon = WagonsRepo.getInstance().get(it)

            val depWay = WaysRepo.getInstance().get(form.departureWay)

            val destWay = WaysRepo.getInstance().get(form.destinationWay)

            val newWagon = wagon?.copy(
                position = form.destinationStation,
                parkId = form.destinationPark,
                wayId = form.destinationWay
            )

            val newDepWay = depWay?.copy(
                wagonsIds = depWay.wagonsIds - it
            )
            val newDestWay = destWay?.copy(
                wagonsIds = destWay.wagonsIds + it
            )

            ShadowMergeRepo.instance.addVirtualWagon(
                formId, newWagon!!
            )

            ShadowMergeRepo.instance.addVirtualWayDep(
                newDepWay!!
            )

            ShadowMergeRepo.instance.addVirtualWayDest(
                newDestWay!!
            )

            ShadowMergeRepo.instance.saveShadowMergeId(
                formId,
                newDepWay.id,
                newDestWay.id,
            )
        }
    }
}