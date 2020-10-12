package com.marraps.home_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.marraps.home_presentation.databinding.HomeListItemBinding
import com.marraps.models.affixes.AffixDetails
import com.marraps.utils.isVisible
import com.marraps.utils.makeVisible
import com.marraps.utils.toggleVisibility

class HomeListAdapter(
    private val affixList: List<AffixDetails>
) : RecyclerView.Adapter<HomeListAdapter.AffixViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AffixViewHolder(
        HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: AffixViewHolder, position: Int) {
        holder.bind(affixList[position])
    }

    override fun getItemCount() = affixList.size

    class AffixViewHolder(
        private val itemBinding: HomeListItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(affixDetails: AffixDetails) {
            itemBinding.homeListItemTitle.text = affixDetails.name

            itemBinding.homeListItemDescription.apply {
                text = affixDetails.description
                makeVisible(false)
            }

            itemBinding.homeListItemExpand.apply {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_expand))
                setOnClickListener {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            if (itemBinding.homeListItemDescription.isVisible()) R.drawable.ic_expand
                            else R.drawable.ic_collapse
                        )
                    )
                    itemBinding.homeListItemDescription.toggleVisibility()
                }
            }


        }
    }
}