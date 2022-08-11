package xyz.teamgravity.roompaging3.data.local.callback

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import xyz.teamgravity.roompaging3.core.util.IndexGenerator
import xyz.teamgravity.roompaging3.data.local.database.IndexDatabase
import xyz.teamgravity.roompaging3.data.mapper.toEntity
import javax.inject.Provider

class IndexCallback(
    private val db: Provider<IndexDatabase>,
    private val scope: CoroutineScope,
    private val generator: IndexGenerator,
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        scope.launch {
            this@IndexCallback.db.get().indexDao().insertIndexes(generator.generateIndexes().map { it.toEntity() })
        }
    }
}