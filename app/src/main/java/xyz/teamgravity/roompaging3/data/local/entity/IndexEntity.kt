package xyz.teamgravity.roompaging3.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import xyz.teamgravity.roompaging3.data.local.constant.IndexConst

@Entity(tableName = IndexConst.TABLE_INDEX)
data class IndexEntity(
    @PrimaryKey
    val index: Long,
)
