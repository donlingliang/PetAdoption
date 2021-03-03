/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Pet Adoption"
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.primary) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            items(pets) {
                PetItemCard(pet = it)
            }
        }
    }
}

@Composable
@Preview
fun PuppyCardPreview() {
    PetItemCard(pet = pets.first())
}

@Composable
fun PetItemCard(pet: Pet) {
    val context = LocalContext.current
    Card(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = { PetInfoActivity.start(context, pet) }),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {
        Row {
            Image(
                painter = painterResource(
                    id = pet.image,
                ),
                null,
                modifier = Modifier
                    .width(112.dp)
                    .height(96.dp)
            )
            Column {
                Text(
                    text = pet.name,
                    Modifier.padding(4.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black
                )
                Row {
                    Text(text = pet.stage.toString(), Modifier.padding(4.dp))
                    Text(text = pet.gender.toString(), Modifier.padding(4.dp))
                }
            }
        }

    }

}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
