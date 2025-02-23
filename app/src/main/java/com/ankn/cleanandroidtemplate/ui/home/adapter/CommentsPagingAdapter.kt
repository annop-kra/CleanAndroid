package com.ankn.cleanandroidtemplate.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ankn.cleanandroidtemplate.databinding.ItemViewBinding
import com.ankn.core.domain.model.Comment

class CommentsPagingAdapter(private val onClickItem: (Comment) -> Unit) :
    PagingDataAdapter<Comment, CommentsPagingAdapter.ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding, onClickItem)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }

    class ItemViewHolder(private val binding: ItemViewBinding, private val onClickItem: (Comment) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Comment) {
            binding.tvName.text = item.name
            binding.tvBody.text = item.body

            binding.root.setOnClickListener { onClickItem.invoke(item) }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment) = oldItem == newItem
        }
    }
}
