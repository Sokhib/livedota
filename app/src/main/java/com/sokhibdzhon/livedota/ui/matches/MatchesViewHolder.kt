package com.sokhibdzhon.livedota.ui.matches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sokhibdzhon.livedota.data.network.model.ProMatches
import com.sokhibdzhon.livedota.databinding.MatchItemBinding


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

class MatchesViewHolder(
    private val binding: MatchItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(proMatch: ProMatches) {
        binding.viewState = MatchesItemViewState(proMatch)
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): MatchesViewHolder {
            val binding = MatchItemBinding.inflate(LayoutInflater.from(parent.context))
            return MatchesViewHolder(binding)
        }
    }


}