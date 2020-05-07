package com.sokhibdzhon.livedota.data.network.model.teamitem


data class TeamLogo(
    val `data`: Data
)

fun TeamLogo.getUrl(): String = data.url