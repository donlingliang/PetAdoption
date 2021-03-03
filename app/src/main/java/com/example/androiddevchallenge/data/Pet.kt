package com.example.androiddevchallenge.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pet(
    val name: String,
    val gender: Gender,
    val stage: LifeStage,
    @DrawableRes val image: Int
) : Parcelable {
    enum class Gender { Male, Female }
    enum class LifeStage { Kitten, Junior, Adult, Mature, Senior }
}

val pets = listOf(
    Pet(
        name = "Azuki",
        gender = Pet.Gender.Male,
        stage = Pet.LifeStage.Adult,
        image = com.example.androiddevchallenge.R.drawable.cat_1
    ),
    Pet(
        name = "Chibi",
        gender = Pet.Gender.Male,
        stage = Pet.LifeStage.Adult,
        image = com.example.androiddevchallenge.R.drawable.cat_2
    ),
    Pet(
        name = "Haru",
        gender = Pet.Gender.Male,
        stage = Pet.LifeStage.Adult,
        image = com.example.androiddevchallenge.R.drawable.cat_3
    ),
    Pet(
        name = "Koko",
        gender = Pet.Gender.Female,
        stage = Pet.LifeStage.Kitten,
        image = com.example.androiddevchallenge.R.drawable.cat_4
    ),
    Pet(
        name = "Miruku",
        gender = Pet.Gender.Male,
        stage = Pet.LifeStage.Senior,
        image = com.example.androiddevchallenge.R.drawable.cat_5
    ),
    Pet(
        name = "Sora",
        gender = Pet.Gender.Male,
        stage = Pet.LifeStage.Adult,
        image = com.example.androiddevchallenge.R.drawable.cat_6
    ),
    Pet(
        name = "Hime",
        gender = Pet.Gender.Male,
        stage = Pet.LifeStage.Adult,
        image = com.example.androiddevchallenge.R.drawable.cat_7
    ),
    Pet(
        name = "Tora",
        gender = Pet.Gender.Female,
        stage = Pet.LifeStage.Adult,
        image = com.example.androiddevchallenge.R.drawable.cat_8
    )
)
