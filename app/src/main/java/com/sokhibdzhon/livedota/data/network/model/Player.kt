package com.sokhibdzhon.livedota.data.network.model


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("account_id")
    val accountId: Int,
    val isRadiant: Boolean,
    val lose: Int,
    val name: String,
    val personaname: String,
    val win: Int
)