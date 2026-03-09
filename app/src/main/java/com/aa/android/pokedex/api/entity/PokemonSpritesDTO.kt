package com.aa.android.pokedex.api.entity

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Contains various sprite image URLs for the Pokemon.
 *
 * @param defaultFront Default Pokémon sprite, front-facing
 * @param defaultBack Default Pokémon sprite, back-facing
 * @param other Other higher-res sprites
 */
@JsonClass(generateAdapter = true)
data class PokemonSpritesDTO(
    @SerializedName("front_default")
//    @Json(name = "front_default")
    val defaultFront: String,
    @Json(name = "back_default")
    val defaultBack: String,
    @Json(name = "other")
    val other: PokemonOtherSpritesDTO
)
