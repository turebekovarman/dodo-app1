package com.example.dodo_app

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.dodo_app.model.Pizza

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}


abstract class BasePizzaViewHolder<VB:ViewBinding>(override val binding: VB):
    BaseViewHolder<VB, Pizza>(binding)