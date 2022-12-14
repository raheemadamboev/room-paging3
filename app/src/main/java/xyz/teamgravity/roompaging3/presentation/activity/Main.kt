package xyz.teamgravity.roompaging3.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.roompaging3.presentation.screen.IndexListScreen
import xyz.teamgravity.roompaging3.presentation.theme.RoomPaging3Theme

@AndroidEntryPoint
class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomPaging3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IndexListScreen()
                }
            }
        }
    }
}
