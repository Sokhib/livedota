package com.sokhibdzhon.livedota.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sokhibdzhon.livedota.R
import com.sokhibdzhon.livedota.data.local.entity.ProMatches
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
            onMatchItemClicked: ((Long, String) -> Unit)?,
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