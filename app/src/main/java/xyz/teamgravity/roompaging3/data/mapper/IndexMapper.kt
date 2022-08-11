package xyz.teamgravity.roompaging3.data.mapper

import xyz.teamgravity.roompaging3.data.local.entity.IndexEntity
import xyz.teamgravity.roompaging3.data.model.IndexModel

fun IndexEntity.toModel(): IndexModel {
    return IndexModel(index = index)
}

fun IndexModel.toEntity(): IndexEntity {
    return IndexEntity(index = index)
}