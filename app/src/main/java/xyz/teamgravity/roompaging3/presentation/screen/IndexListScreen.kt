package xyz.teamgravity.roompaging3.presentation.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import xyz.teamgravity.roompaging3.R
import xyz.teamgravity.roompaging3.presentation.component.progressbar.CenteredProgressBar
import xyz.teamgravity.roompaging3.presentation.viewmodel.IndexListViewModel

@Composable
fun IndexListScreen(
    viewmodel: IndexListViewModel = hiltViewModel(),
) {
    val indexes = viewmodel.indexes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.indexes))
                }
            )
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            if (indexes.loadState.prepend == LoadState.Loading) item { CenteredProgressBar() }

            items(
                items = indexes,
                key = { it.index }
            ) { index ->
                if (index != null) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = index.index.toString(),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}