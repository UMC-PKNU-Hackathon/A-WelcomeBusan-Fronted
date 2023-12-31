package com.pknu.busannollerwar.presentation.thingstodo.articleDetail.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pknu.busannollerwar.databinding.ItemArticleReviewImageBinding

class ReviewViewHolder(
    private val fragmentViewModel: ReviewViewModel,
    private val binding: ItemArticleReviewImageBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(idx: Int, item: String) {
        binding.apply {
            viewModel = fragmentViewModel
            index = idx

            if (item != "") {
                ivItemImage.visibility = View.VISIBLE
                Glide.with(clArticleImageItem.context).load(item)
                    .into(ivItemImage)
            } else {
                ivItemImage.visibility = View.GONE
            }
        }
    }
}

class ReviewListAdapter(
    private val viewModel: ReviewViewModel,
) :
    ListAdapter<String, ReviewViewHolder>(object :
        DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemArticleReviewImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReviewViewHolder(viewModel, binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }
}




