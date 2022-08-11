package xyz.teamgravity.roompaging3.injection.provide

import android.app.Application
import androidx.paging.PagingConfig
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import xyz.teamgravity.roompaging3.core.constant.PagingConst
import xyz.teamgravity.roompaging3.core.util.IndexGenerator
import xyz.teamgravity.roompaging3.data.local.callback.IndexCallback
import xyz.teamgravity.roompaging3.data.local.constant.IndexConst
import xyz.teamgravity.roompaging3.data.local.dao.IndexDao
import xyz.teamgravity.roompaging3.data.local.database.IndexDatabase
import xyz.teamgravity.roompaging3.data.repository.IndexRepository
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    @Provides
    @Singleton
    fun provideIndexGenerator(): IndexGenerator = IndexGenerator()

    @Provides
    @Singleton
    fun provideIndexCallback(
        indexDatabase: Provider<IndexDatabase>,
        coroutineScope: CoroutineScope,
        indexGenerator: IndexGenerator,
    ): IndexCallback = IndexCallback(
        db = indexDatabase,
        scope = coroutineScope,
        generator = indexGenerator
    )

    @Provides
    @Singleton
    fun provideIndexDatabase(application: Application, indexCallback: IndexCallback): IndexDatabase =
        Room.databaseBuilder(application, IndexDatabase::class.java, IndexConst.NAME)
            .addCallback(indexCallback)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideIndexDao(indexDatabase: IndexDatabase): IndexDao = indexDatabase.indexDao()

    @Provides
    @Singleton
    fun providePagingConfig(): PagingConfig = PagingConfig(
        pageSize = PagingConst.PAGE_SIZE,
        maxSize = PagingConst.MAX_SIZE,
        enablePlaceholders = PagingConst.ENABLE_PLACEHOLDERS
    )

    @Provides
    @Singleton
    fun provideIndexRepository(indexDao: IndexDao, pagingConfig: PagingConfig): IndexRepository =
        IndexRepository(
            dao = indexDao,
            config = pagingConfig
        )
}