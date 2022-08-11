package xyz.teamgravity.roompaging3.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import xyz.teamgravity.roompaging3.data.local.entity.IndexEntity

@Dao
interface IndexDao {

    ///////////////////////////////////////////////////////////////////////////
    // INSERT
    ///////////////////////////////////////////////////////////////////////////

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIndexes(indexes: List<IndexEntity>)

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getIndexes(): PagingSource<Int, IndexEntity>
}