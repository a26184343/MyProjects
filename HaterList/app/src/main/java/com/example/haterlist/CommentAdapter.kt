package com.example.haterlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter (val context: Context, val commentList: ArrayList<Hater>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    class CommentViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val hater_no = v.findViewById<TextView>(R.id.comment_no)
        val hater_body = v.findViewById<TextView>(R.id.comment_body)
        val hater_star = v.findViewById<TextView>(R.id.comment_star)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CommentViewHolder {
            val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.comment_adapter, viewGroup, false)
            return CommentViewHolder(v)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val hater = commentList[position]
        holder.hater_no.text = (position + 1).toString()
        holder.hater_body.text = hater.comment
        holder.hater_star.text = hater.star.toString()
        val viewComments = ViewComments()
        viewComments.add(1)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}
