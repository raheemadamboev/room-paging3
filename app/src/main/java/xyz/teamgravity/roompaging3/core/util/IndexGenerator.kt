package xyz.teamgravity.roompaging3.core.util

import xyz.teamgravity.roompaging3.data.model.IndexModel

class IndexGenerator {

    fun generateIndexes(): List<IndexModel> {
        val indexes = mutableListOf<IndexModel>()
        repeat(600) { indexes.add(IndexModel(index = it.toLong())) }
        return indexes
    }
}