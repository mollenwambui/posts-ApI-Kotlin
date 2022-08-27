package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.PostListItemsBinding

class PostRVAdapter (var context: Context, var postList: List<Post>):
    RecyclerView.Adapter<PostRVAdapter.RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding = PostListItemsBinding

            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentPost = postList.get(position)
        with(holder.binding) {
            tvUserId.text = currentPost.userId.toString()
            tvId.text = currentPost.id.toString()
            tvTitle.text = currentPost.title
            tvBody.text = currentPost.body

           val context=holder.itemView.context
            holder.binding.cvPosts.setOnClickListener {
                val intent=Intent(context,CommentActivity::class.java)
                intent.putExtra("POST_ID",currentPost.id)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }


    class RetrofitViewHolder(var binding: PostListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}