package com.example.challengeopener

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeopener.databinding.RecyclerviewChallengesItemBinding

class ChallengesAdapter(private val context: Context, private var list: List<NewActivityInfo>) :
    RecyclerView.Adapter<ChallengesAdapter.ChallengesHolder>() {

    inner class ChallengesHolder(private var binding: RecyclerviewChallengesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = list[position]
            binding.run {
                constraintlayoutChallengesDetailContainer.visibility = View.GONE
                txtviewChallengesDetailDescription.text = item.activityDescription
                btnChallengesOpener.text = item.activityTitle
                btnChallengesOpener.icon = getDrawable(context, item.activityIcon)
                btnChallengesOpener.setOnClickListener {
                    when(position){
                        //0 -> context.startActivity(Intent(context,::class.java))
                        else -> {}
                    }
                }
                togglebtnChallengesDetailopener.setOnCheckedChangeListener { _, isChecked ->
                    toggleDetailsVisibility(isChecked)
                }

            }
        }

        fun toggleDetailsVisibility(isChecked: Boolean) {
            if (isChecked) {
                binding.constraintlayoutChallengesDetailContainer.visibility = View.VISIBLE
            } else {
                binding.constraintlayoutChallengesDetailContainer.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengesHolder =
        ChallengesHolder(
            RecyclerviewChallengesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ChallengesHolder, position: Int) = holder.bind(position)

    override fun getItemCount(): Int = list.size
}