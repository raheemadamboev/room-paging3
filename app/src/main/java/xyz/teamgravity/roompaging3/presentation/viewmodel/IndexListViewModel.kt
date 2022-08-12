package xyz.teamgravity.roompaging3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.roompaging3.data.model.IndexModel
import xyz.teamgravity.roompaging3.data.repository.IndexRepository
import javax.inject.Inject

@HiltViewModel
class IndexListViewModel @Inject constructor(
    repository: IndexRepository,
) : ViewModel() {

    val indexes: Flow<PagingData<IndexModel>> = repository.getIndexes().cachedIn(viewModelScope)
}