package com.sokhibdzhon.livedota.data.network.model.matchdetails


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("account_id")
    val accountId: Int,
    val assists: Int,
    @SerializedName("backpack_0")
    val backpack0: Int,
    @SerializedName("backpack_1")
    val backpack1: Int,
    @SerializedName("backpack_2")
    val backpack2: Int,
    val deaths: Int,
    val denies: Int,
    val gold: Int,
    @SerializedName("gold_per_min")
    val goldPerMin: Int,
    @SerializedName("gold_spent")
    val goldSpent: Int,
    @SerializedName("hero_damage")
    val heroDamage: Int,
    @SerializedName("hero_healing")
    val heroHealing: Int,
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("item_0")
    val item0: Int,
    @SerializedName("item_1")
    val item1: Int,
    @SerializedName("item_2")
    val item2: Int,
    @SerializedName("item_3")
    val item3: Int,
    @SerializedName("item_4")
    val item4: Int,
    @SerializedName("item_5")
    val item5: Int,
    @SerializedName("item_neutral")
    val itemNeutral: Int,
    val kills: Int,
    @SerializedName("last_hits")
    val lastHits: Int,
    @SerializedName("leaver_status")
    val leaverStatus: Int,
    val level: Int,
    @SerializedName("player_slot")
    val playerSlot: Int,
    @SerializedName("scaled_hero_damage")
    val scaledHeroDamage: Int,
    @SerializedName("scaled_hero_healing")
    val scaledHeroHealing: Int,
    @SerializedName("scaled_tower_damage")
    val scaledTowerDamage: Int,
    @SerializedName("tower_damage")
    val towerDamage: Int,
    @SerializedName("xp_per_min")
    val xpPerMin: Int
)