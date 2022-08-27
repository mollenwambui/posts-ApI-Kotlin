package com.example.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypost.databinding.CommentListItemsBinding

class CommentsRvAdapter(var commentList:List<Comment>):
RecyclerView.Adapter<CommentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding=CommentListItemsBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
            return CommentViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.binding.tvId2.text=currentComment.postId.toString()
        holder.binding.tvName.text=currentComment.name
        holder.binding.tvEmail.text=currentComment.email
        holder.binding.tvBody2.text=currentComment.body


        }

    override fun getItemCount(): Int {
     return  commentList.size
    }
}
class  CommentViewHolder(var binding:CommentListItemsBinding):RecyclerView.ViewHolder(binding.root){

}