package com.sokhibdzhon.livedota.ui.matches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.databinding.MatchItemBinding


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

class MatchesViewHolder(
    private val binding: MatchItemBinding,
    private val onMatchItemClicked: ((Long, String) -> Unit)?,
    private val onFavoriteClicked: ((ProMatches) -> Unit)?
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.constraintItem.setOnClickListener {
            onMatchItemClicked?.invoke(
                binding.viewState!!.getMatchId(),
                binding.viewState!!.getLeagueName()
            )
        }
        binding.favoriteImageView.setOnClickListener {

            //TODO: Add and remove from favorites.
            onFavoriteClicked?.invoke(binding.viewState!!.match)
        }
    }

    fun bind(proMatch: ProMatches) {
        binding.viewState = MatchesItemViewState(proMatch)
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onMatchItemClicked: ((Long, String) -> Unit)?,
            onFavoriteClicked: ((ProMatches) -> Unit)?
        ): MatchesViewHolder {
            val binding = MatchItemBinding.inflate(LayoutInflater.from(parent.context))
            return MatchesViewHolder(binding, onMatchItemClicked, onFavoriteClicked)
        }
    }


}