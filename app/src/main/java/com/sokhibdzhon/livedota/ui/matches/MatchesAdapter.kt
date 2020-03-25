package com.sokhibdzhon.livedota.ui.matches

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import javax.inject.Inject


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

class MatchesAdapter @Inject constructor() : RecyclerView.Adapter<MatchesViewHolder>() {

    private val matchesList = arrayListOf<ProMatches>()

    fun setMatchList(matchesList: List<ProMatches>) {
        this.matchesList.apply {
            clear()
            addAll(matchesList)
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MatchesViewHolder.create(parent)

    override fun getItemCount() = matchesList.size

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        return holder.bind(matchesList[position])
    }

}