package br.senai.sp.jandira.layoutimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.layoutimc.ui.theme.LayoutIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutIMCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column (
        modifier =  Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Coluna vermelha do título e logo
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = Color.Red)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = painterResource(id = R.drawable.imc),
                contentDescription = "",
                alignment = Alignment.Center ,
                modifier = Modifier.size(70.dp))
            Text(
                text = "Calculadora IMC",
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold)
        }
        //Card com os inputs para a calculadora
        Card (
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .offset(y = -40.dp)
        ) {
            //Coluna para organizar os elementos um em cima do outro
            Column (
                modifier = Modifier.padding(20.dp)
            ){
                Text(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    text = "Seus dados",
                    color = Color.Red,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )

                Text(text = "Seu peso", color = Color.Red)
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Seu peso em Kg")
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Red,
                        unfocusedPlaceholderColor = Color.LightGray,
                        unfocusedContainerColor = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )

                Text(text = "Sua altura", color = Color.Red)
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = {
                        Text(text = "Sua altura em cm")
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Red,
                        unfocusedPlaceholderColor = Color.LightGray,
                        unfocusedContainerColor = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )

                Button(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    ),
                    shape = RectangleShape,
                    onClick = {}
                ) {
                    Text(text = "CALCULAR")
                }
            }
        }

        Card (
            modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.Green

            )
        ){
                Row (modifier = Modifier.padding(16.dp)){
                    Column {
                        Text(text = "Resultado", color = Color.White)
                        Text(text = "Peso Ideal", color = Color.White)
                    }
                    Text(text = "21.3", fontSize = 40.sp, color = Color.White)
                }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LayoutIMCTheme {
        Greeting()
    }
}