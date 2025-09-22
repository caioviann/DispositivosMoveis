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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
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

@Composable
fun Dados(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier
            .padding(16.dp)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            var face by rememberSaveable { mutableStateOf(1) }
            var face2 by rememberSaveable { mutableStateOf(1) }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    face = (1..6).random()
                    face2 = (1..6).random()
                }
            ) {
                Text("Jogar", fontSize = 24.sp)
            }
            Image(
                painter = painterResource(Imagem(face)),
                contentDescription = face.toString()
            )
            Image(
                painter = painterResource(Imagem(face2)),
                contentDescription = face.toString()
            )
            Text(RegraDoJogo(face, face2))
        }
    }
}
fun Imagem (face: Int, modifier: Modifier = Modifier): Int {
    val imagem = when (face) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    return imagem
}
fun RegraDoJogo(dado1: Int, dado2: Int, modifier: Modifier = Modifier): String{
    var soma = dado1 + dado2
    if (soma == 7 || soma == 11){
        return "Você ganhou"
    }else if (soma == 2 || soma == 3 || soma == 12){
        return "Você perdeu"
    }
    return "Ishh, tente novamente"
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DadosPrev() {
    Dados()
}