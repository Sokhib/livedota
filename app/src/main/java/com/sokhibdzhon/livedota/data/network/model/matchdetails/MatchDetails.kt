package com.sokhibdzhon.livedota.data.network.model.matchdetails


data class MatchDetails(
    val result: Result
)

fun MatchDetails.getPlayers(): List<Player> = result.players
fun MatchDetails.getRadiantLogo(): Long = result.radiantLogo
fun MatchDetails.getDireLogo(): Long = result.direLogo