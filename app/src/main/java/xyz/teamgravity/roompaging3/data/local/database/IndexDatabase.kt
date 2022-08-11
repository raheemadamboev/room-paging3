package xyz.teamgravity.roompaging3.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.teamgravity.roompaging3.data.local.constant.IndexConst
import xyz.teamgravity.roompaging3.data.local.dao.IndexDao
import xyz.teamgravity.roompaging3.data.local.entity.IndexEntity

@Database(
    entities = [IndexEntity::class],
    version = IndexConst.VERSION,
    exportSchema = false
)
abstract class IndexDatabase : RoomDatabase() {

    abstract fun indexDao(): IndexDao
}