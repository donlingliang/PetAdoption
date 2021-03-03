package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.ui.theme.MyTheme

class PetInfoActivity : AppCompatActivity() {
    companion object {
        private const val PET: String = "PET"
        fun start(context: Context, pet: Pet) {
            val intent = Intent(context, PetInfoActivity::class.java).apply {
                putExtra(PET, pet);
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pet: Pet? = intent.extras?.getParcelable(PET)

        requireNotNull(pet)
        title = pet?.name
        setContent {
            MyTheme {
                PetInfoScreen(pet = pet)
            }
        }
    }
}

@Composable
@Preview
fun PetInfoScreenPreview() {
    PetInfoScreen(pet = pets.first())
}

@Composable
fun PetInfoScreen(pet: Pet) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp, backgroundColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = rememberRipple(bounded = false)
                        ) {}
                        .padding(8.dp),
                    tint = MaterialTheme.colors.primaryVariant
                )
            }
        }) {

        Column(
            modifier = Modifier
                .background(
                    color = Color.LightGray,
                )
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
                    .fillMaxWidth()
                    .height(450.dp)
            ) {

                Column(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    ) {
                        Image(
                            painter = painterResource(id = pet.image),
                            contentDescription = pet.name,
                            modifier = Modifier
                                .width(240.dp)
                                .height(240.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Row(modifier = Modifier.fillMaxWidth().align(alignment = Alignment.CenterHorizontally)) {
                    Spacer(modifier = Modifier.size(40.dp))
                    BorderedButton(pet.gender.toString())
                    Spacer(modifier = Modifier.size(12.dp))
                    BorderedButton(pet.name.toString())
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Summary",
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp), color = Color.Gray,
                        text = "Very friendly and well-behaved male cat. He is potty trained and responds whenever he is called. And, he's neutered.",
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.size(100.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                FloatingActionButton(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .size(150.dp, 150.dp)
                        .padding(0.dp),
                    onClick = {}) {
                    Text(
                        text = "Adopt",
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 36.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun BorderedButton(text: String) {
    Surface(
        modifier = Modifier.padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color.DarkGray)
    ) {
        Text(
            text = text,
            color = Color.DarkGray,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
        )
    }
}