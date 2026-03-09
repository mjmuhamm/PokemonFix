package com.aa.android.pokedex.model.secondModel

data class SecondScreenResponse(
    var abilities: List<Ability> = emptyList(),
    var base_experience: Int = 0,
    var cries: Cries? = null,
    var forms: List<Form> = emptyList(),
    var game_indices: List<GameIndice> = emptyList(),
    var height: Int = 0,
    var held_items: List<Any?> = emptyList(),
    var id: Int = 0,
    var is_default: Boolean? = null,
    var location_area_encounters: String = "",
    var moves: List<Move> = emptyList(),
    var name: String = "",
    var order: Int = 0,
    var past_abilities: List<PastAbility> = emptyList(),
    var past_stats: List<PastStat> = emptyList(),
    var past_types: List<Any?> = emptyList(),
    var species: Species? = null,
    var sprites: Sprites? = null,
    var stats: List<StatXX> = emptyList(),
    var types: List<Type> = emptyList(),
    var weight: Int = 0
)