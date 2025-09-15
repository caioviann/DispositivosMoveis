package ads.mov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ads.mov.ui.theme.MyApplicationTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
//-------------------------------------------------------
@Composable
fun Saudacao(nome: String, modifier: Modifier = Modifier){
    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(
                vertical = 4.dp, horizontal = 8.dp
            )
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .padding(all = 8.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Text(text = "Olá")
           Text(text = nome)
       }
    }
}
@Composable
fun ChamaSaudacao(modifier: Modifier = Modifier){
    Column {
        Saudacao("Mundo", Modifier.weight(1f))
        Saudacao("Compose", Modifier.weight(2f))
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewSaudacao() {
    MyApplicationTheme {
        ChamaSaudacao()
    }
}
//--------------------------------------------------------

@Composable
fun Imagem(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .fillMaxSize()
    ) {
        Box() {
            Image(
                painter = painterResource(R.drawable.fundo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 1.0f
            )
            Text(
                text = "Bom dia",
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
                )
            Text(
                text = "ADS",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.sp)
                    .align(alignment = Alignment.End)
            )

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ImagePreview() {
    MyApplicationTheme {
        Imagem()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}