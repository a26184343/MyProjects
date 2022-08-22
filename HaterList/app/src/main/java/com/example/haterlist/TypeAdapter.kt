package com.example.haterlist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class TypeAdapter(val context: Context) : RecyclerView.Adapter<TypeAdapter.ViewHolder>() {

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val type_image = v.findViewById<ImageView>(R.id.type_image)
        val type_button = v.findViewById<Button>(R.id.type_button)
    }

    override fun getItemCount() = typeTitles.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
            ViewHolder {
                val v = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.type_row, viewGroup, false)
                return ViewHolder(v)
    }

    //every button's category name & it's image
    private val typeTitles = arrayOf("租屋", "餐飲", "汽機車", "借貸", "賣場")
    private val images = intArrayOf(R.drawable.bed, R.drawable.burger, R.drawable.moto, R.drawable.debt, R.drawable.market)

    //key word for transforming it's own page
    private val typeKeywords = arrayOf("Rent", "Restaurant", "Motors", "Debt", "Market")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.type_image.setImageResource(images[position])
        holder.type_button.text = typeTitles[position]

        //intent & buttons
        var i = Intent(context, CategoryView::class.java)
        i.putExtra("category", typeKeywords[position])
        holder.type_image.setOnClickListener {
            context.startActivity(i)
        }
        holder.type_button.setOnClickListener {
            context.startActivity(i)
        }
    }
}