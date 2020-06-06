package com.sokhibdzhon.livedota.ui.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import javax.inject.Inject


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */
//TODO: What if to send onClick through constructor what to change in DI classes.
class MatchesAdapter @Inject constructor() : RecyclerView.Adapter<MatchesViewHolder>() {

    private val matchesList = arrayListOf<ProMatches>()
    var onMatchItemClicked: ((Long, String) -> Unit)? = null
    var onFavoriteClicked: ((ProMatches) -> Unit)? = null
    fun setMatchList(matchesList: List<ProMatches>) {
        this.matchesList.apply {
            clear()
            addAll(matchesList)
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchesViewHolder.create(
            parent,
            onMatchItemClicked,
            onFavoriteClicked
        )

    override fun getItemCount() = matchesList.size

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        return holder.bind(matchesList[position])
    }

}