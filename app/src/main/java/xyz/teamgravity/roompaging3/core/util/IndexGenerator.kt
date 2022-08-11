package xyz.teamgravity.roompaging3.core.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import xyz.teamgravity.roompaging3.data.model.IndexModel

class IndexGenerator {

    suspend fun generateIndexes(): List<IndexModel> {
        return withContext(Dispatchers.Default) {
            val indexes = mutableListOf<IndexModel>()
            repeat(600) { indexes.add(IndexModel(index = it.toLong())) }
            return@withContext indexes
        }
    }
}