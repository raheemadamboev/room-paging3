package xyz.teamgravity.roompaging3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import xyz.teamgravity.roompaging3.data.local.dao.IndexDao
import xyz.teamgravity.roompaging3.data.local.entity.IndexEntity
import xyz.teamgravity.roompaging3.data.mapper.toModel
import xyz.teamgravity.roompaging3.data.model.IndexModel

class IndexRepository(
    private val dao: IndexDao,
    private val config: PagingConfig,
) {

    ///////////////////////////////////////////////////////////////////////////
    // PAGER
    ///////////////////////////////////////////////////////////////////////////

    private val getIndexesPager: Pager<Int, IndexEntity> by lazy { Pager(config) { dao.getIndexes() } }

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getIndexes(): Flow<PagingData<IndexModel>> {
        return getIndexesPager.flow.map { entities -> entities.map { it.toModel() } }
    }
}