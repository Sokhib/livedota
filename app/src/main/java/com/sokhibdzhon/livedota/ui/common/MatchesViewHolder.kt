package com.sokhibdzhon.livedota.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
import com.sokhibdzhon.livedota.data.model.LeagueName
import com.sokhibdzhon.livedota.data.model.MatchId
import com.sokhibdzhon.livedota.databinding.MatchItemBinding
import com.sokhibdzhon.livedota.ui.matches.MatchesItemViewState


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

class MatchesViewHolder(
    private val binding: MatchItemBinding,
    private val onMatchItemClicked: ((MatchId, LeagueName) -> Unit)?,
    private val onFavoriteClicked: ((ProMatches) -> Unit)?
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.constraintItem.setOnClickListener {
            onMatchItemClicked?.invoke(
                MatchId(binding.viewState!!.getMatchId()),
                LeagueName(binding.viewState!!.getLeagueName())
            )
        }
        binding.favoriteImageView.setOnClickListener {

            onFavoriteClicked?.invoke(binding.viewState!!.match)
        }
    }

    fun bind(proMatch: ProMatches) {
        binding.viewState =
            MatchesItemViewState(proMatch)
//        val params = binding.constraintItem.layoutParams as? ViewGroup.MarginLayoutParams
//        if (params?.topMargin != null) {
//            params.topMargin = 24
//            binding.constraintItem.layoutParams = params
//        }
        binding.executePendingBindings()
    }
    //  MatchItemBinding.inflate(LayoutInflater.from(parent.context)) problem with margin was in this code

    companion object {
        fun create(
            parent: ViewGroup,
            onMatchItemClicked: ((MatchId, LeagueName) -> Unit)?,
            onFavoriteClicked: ((ProMatches) -> Unit)?
        ): MatchesViewHolder {
            val binding = DataBindingUtil.inflate<MatchItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.match_item,
                parent,
                false
            )
            return MatchesViewHolder(
                binding,
                onMatchItemClicked,
                onFavoriteClicked
            )
        }
    }


}