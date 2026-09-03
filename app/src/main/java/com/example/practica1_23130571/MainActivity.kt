package com.example.practica1_23130571

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica1_23130571.ui.theme.Practica1_23130571Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Practica1_23130571Theme {
                Contador()
            }
        }
    }
}

@Composable
fun Contador() {

    var numero by remember {
        mutableIntStateOf(0)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {

            // COLUMN
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(650.dp)
                    .border(
                        BorderStroke(2.dp, Color.DarkGray),
                        RoundedCornerShape(15.dp)
                    )
                    .padding(25.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // BOX
                Box(
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .border(
                            BorderStroke(2.dp, Color.Blue),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    // TEXT
                    Text(
                        text = numero.toString(),
                        fontSize = 55.sp,
                        color = Color.Blue
                    )
                }

                // ROW
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

                    // LAZYROW
                    LazyRow(
                        horizontalArrangement = Arrangement.Center
                    ) {

                        item {

                            // BUTTON
                            Button(
                                onClick = {
                                    numero++
                                },
                                modifier = Modifier.height(55.dp),
                                shape = RoundedCornerShape(30.dp)
                            ) {

                                // TEXT
                                Text(
                                    text = "Sumar",
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorPreview() {
    Practica1_23130571Theme {
        Contador()
    }
}