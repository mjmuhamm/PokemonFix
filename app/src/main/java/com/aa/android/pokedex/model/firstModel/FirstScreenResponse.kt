package com.aa.android.pokedex.model.firstModel

data class FirstScreenResponse(
    var count: Int = 0,
    var next: String = "",
    var previous: Any = "",
    var results: List<Result> = emptyList()
)