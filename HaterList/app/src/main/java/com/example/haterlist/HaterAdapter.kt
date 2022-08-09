package com.example.haterlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HaterAdapter(val context: Context, val haters: ArrayList<Hater>, val category: String):
    RecyclerView.Adapter<HaterAdapter.HaterAdapterViewHolder>() {

        class HaterAdapterViewHolder(v: View): RecyclerView.ViewHolder(v) {
            val hater_name = v.findViewById<TextView>(R.id.adapter_name)
            val hater_phone = v.findViewById<TextView>(R.id.adapter_phone)
            val comments_button = v.findViewById<Button>(R.id.view_comments)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int):
            HaterAdapterViewHolder {
            val v = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.hater_adapter, viewGroup, false)
            return HaterAdapterViewHolder(v)
        }

        override fun onBindViewHolder(holder: HaterAdapterViewHolder, position: Int) {
            val hater = haters[position]

            holder.hater_name.text = hater.name
            holder.hater_phone.text =hater.phone
            holder.comments_button.setOnClickListener {
                var i = Intent(context, ViewComments::class.java)
                i.putExtra("name", hater.name)
                i.putExtra("phone", hater.phone)
                i.putExtra("category", category)
                context.startActivity(i)
            }
        }

        override fun getItemCount(): Int {
            return haters.size
        }

}