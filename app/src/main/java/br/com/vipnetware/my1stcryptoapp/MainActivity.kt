package br.com.vipnetware.my1stcryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.vipnetware.my1stcryptoapp.screens.main.MainScreenViewModel
import br.com.vipnetware.my1stcryptoapp.ui.theme.My1stCryptoAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val addr = "bc1qqj7rau384r7lqxhgr6940gucq673t34xv8hpsl"
//        viewModel.getAddrInfo(addr)
//        viewModel.fetchUsers()
        viewModel.getLastBlock()
        setContent {
            My1stCryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Emilio")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    My1stCryptoAppTheme {
        Greeting("Android")
    }
}