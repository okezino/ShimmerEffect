package com.example.shimmereffect.model

data class PokeResult(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)