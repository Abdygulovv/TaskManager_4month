package com.example.abdygulov_chyngyz_4_month.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.abdygulov_chyngyz_4_month.databinding.ItemOnboardingBinding
import com.example.abdygulov_chyngyz_4_month.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = listOf(
        OnBoarding("chyngyz", "abdygulov", ""),
        OnBoarding("adceac", "casec", ""),
        OnBoarding("ceasc", "fcsaervcw", "")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder
            (binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDescription.text = onBoarding.description
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }

        }
    }

}