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
import ads.mov.ui.theme.MyApplicationTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ListaDisciplinas(disciplinas = DataSource.disciplinas)
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

data class Disciplina(val sigla: String, val nome:
String, val cargaHoraria: Int, val ementa: String)
object DataSource {
    val disciplinas = listOf(
        Disciplina("SEG", "Segurança", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("MOV", "Dispositivos movéis", 80,"Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("POO", "Programação orientada a objetos", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("FDM", "Fudamentos da matemática", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("ATV", "Atividade de extensão", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("ABC", "abcd", 40, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("DEV", "gagaH", 60,"Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("HWA", "hfavbf", 80,"Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("GJK", "fjansjfna", 60, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("KFA", "8hifuifwa", 40, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("HAS", "hfebyha", 120, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("AIG", "kasfnka", 40, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("AFG", "jnabfsjbajg", 60, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("GYA", "gflfkgnsjgb", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("SEG", "Segurança", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("MOV", "Dispositivos movéis", 80,"Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("POO", "Programação orientada a objetos", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("FDM", "Fudamentos da matemática", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("ATV", "Atividade de extensão", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("ABC", "abcd", 40, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("DEV", "gagaH", 60,"Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("HWA", "hfavbf", 80,"Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),
        Disciplina("GJK", "fjansjfna", 60, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("KFA", "8hifuifwa", 40, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("HAS", "hfebyha", 120, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("AIG", "kasfnka", 40, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("AFG", "jnabfsjbajg", 60, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "
        ),
        Disciplina("GYA", "gflfkgnsjgb", 80, "Uma ementa universitária, em geral, apresenta muito sucintamente as ideias gerais sobre quaisquer assuntos que serão abordadas ao longo da disciplina, como forma de um fichamento (frases soltas, de forma bem sintética). A apresentação mais detalhada dos assuntos que serão estudados, ponto a ponto, é dada no programa de curso. "),

    )
}

@Composable
fun CartaoDisciplina(disciplina: Disciplina, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .animateContentSize()
            .padding(8.dp),
        elevation = cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top
        ){
            var isExpanded by rememberSaveable { mutableStateOf(false) }
            Text(
                text = "${disciplina.sigla}"
            )

                Column(
                    modifier = Modifier.clickable { isExpanded = !isExpanded }
                ) {
                    Text(
                        text = "${disciplina.nome}"
                    )
                        Text(
                            text = "${disciplina.cargaHoraria}"
                        )
                            Text(
                                text = "Ementa: ${disciplina.ementa}",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                }
        }
    }
}

@Composable
fun ListaDisciplinas(disciplinas: List<Disciplina>, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .padding(
                vertical = 4.dp, horizontal = 8.dp
            )
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ){
        LazyColumn {
            items(disciplinas) {
                    disciplina ->
                CartaoDisciplina(
                    disciplina = disciplina
                )
            }
        }
    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun prev() {
    ListaDisciplinas(disciplinas = DataSource.disciplinas)
}