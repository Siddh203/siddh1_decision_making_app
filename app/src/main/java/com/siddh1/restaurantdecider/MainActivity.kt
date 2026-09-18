package com.siddh1.restaurantdecider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddh1.restaurantdecider.ui.theme.RestaurantDeciderTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantDeciderTheme {
                RestaurantDeciderApp()
            }
        }
    }
}
@Composable
fun RestaurantDeciderApp() {
    var result by remember { mutableStateOf("") }
    var clicks by remember { mutableIntStateOf(0) }
    fun decide(chanceOfYes: Int) {
        clicks++
        val randomNumber = Random.nextInt(100)
        result = if (randomNumber < chanceOfYes) {
            "Yes, you should go!"
        } else {
            "No, you should not go."
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Restaurant Decider",
            fontSize = 28.sp
        )
        Text(
            text = "CCID: siddh1\nStudent ID: 1803673",
            textAlign = TextAlign.Center
        )
        Text(
            text = result,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { decide(50) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Really Want to Go")
        }
        Button(
            onClick = { decide(25) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kind of Want to Go")
        }
        Button(
            onClick = { decide(10) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Don't Really Want to Go")
        }
        Box(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onBackground)
                .padding(16.dp)
        ) {
            Text("Clicks: $clicks")
        }
    }
}
