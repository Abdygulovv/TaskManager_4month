package com.example.abdygulov_chyngyz_4_month.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.abdygulov_chyngyz_4_month.databinding.ItemOnboardingBinding
import com.example.abdygulov_chyngyz_4_month.model.OnBoarding
import com.example.abdygulov_chyngyz_4_month.utils.loadImage

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding("Agriculture", "Cultivating ideas for Growth", "https://plasticseurope.org/wp-content/uploads/2021/10/5.6._aaheader.png"),
        OnBoarding("Cattle", "Simple, Organic, Healthy", "https://cdn.britannica.com/23/222923-050-BC27479B/Gaucho-rounding-up-cattle-Gran-Chaco-Paraguay.jpg"),
        OnBoarding("Poultry", "We are best poultry in town","https://www.purina.com/_gatsby/image/0af4ba9f1ef81cd0e703fb3284b28c17/c50c5db61b6c39ed6541d697eeb4772a/what-is-poultry-by-product-meal-in-dog-food.jpg?eu=a6d850c35d2f627491e25e9c30849d64cfb5997f21ffca7ac0d8305a5134164abbe6d7c1e284cb523a1a6cae824912b3e098cf2bf6ea5a16b9ffcba5b23822bac284f723aec54f7fe71cec0e3d6a4938f2e1944224e0865395c8a904302cebe631afb44bb1937cb9b0aa24c8d51fd7e95d2408ea48334ca997fe1da1fa93156ccc5a096c1d9a90e3fe96ed9d8c5df38f78d4ccdc81ae2fcd6eb7e38afccf2372af7f61915337b756a26d8cc4f0194d8e1d6e7b5bc49d70f0e311edf8175f28dbb07c&a=w%3D400%26h%3D200%26fit%3Dcrop%26crop%3Dentropy%26fm%3Djpg%26q%3D75&cd=b766c2b8c248dce05c960037a7e41e0d")
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
            onBoarding.image?.let { binding.ivOnBoarding.loadImage(it) }
            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }

        }
    }

}