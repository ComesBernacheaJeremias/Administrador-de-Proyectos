package com.example.administradordeproyectos.ui

import android.graphics.Color.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CardProject() {
    val cardBackgroundColor = Color(parseColor("#4695db"))

    Card(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Box(modifier = Modifier.fillMaxSize().background(color = cardBackgroundColor)) {
            Column(modifier = Modifier.padding(top = 10.dp).background(Color.Transparent)) {


                Text(
                    text = "Administrar Proyectos",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 30.sp,
                    maxLines = 1,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis // Agregar '...'
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "09/09/2024",
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "12/09/2024",
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "En Proceso",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 15.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "CORCHO",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}
