package com.example.assign3_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assign3_4.ui.theme.Assign3_4Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign3_4Theme {
                ScaffoldExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(){
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        // top bar with the app title
        topBar = {
            TopAppBar(
                title = { Text("Scaffold Example", style = MaterialTheme.typography.titleLarge) }
            )
        },
        // bottom bar with navigation buttons
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            ){
                // home button
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f).padding(10.dp)){
                    Text("Home")
                }
                // settings button
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f).padding(10.dp)){
                    Text("Settings")
                }
                //profile button
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f).padding(10.dp)){
                    Text("Profile")
                }
            }
        },
        //floating action button that triggers snackbar message
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Button Clicked!", actionLabel = "Dismiss")
                    }
                }){
                Text("Click me!")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        //snackbar host that will display the message
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        //content for scaffold that uses inner padding to avoid overlap
        content = { innerPadding ->
            Text("Scaffold content", modifier = Modifier.padding(innerPadding))
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assign3_4Theme {
        ScaffoldExample()
    }
}