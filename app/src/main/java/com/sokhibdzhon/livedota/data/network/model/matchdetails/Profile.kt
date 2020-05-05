package com.sokhibdzhon.livedota.data.network.model.matchdetails


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("account_id")
    val accountId: Int,
    val avatar: String,
    val avatarfull: String,
    val avatarmedium: String,
    val cheese: Int,
    @SerializedName("is_contributor")
    val isContributor: Boolean,
    @SerializedName("last_login")
    val lastLogin: String,
    val loccountrycode: Any,
    val name: String,
    val personaname: String,
    val plus: Boolean,
    val profileurl: String,
    val steamid: String
)