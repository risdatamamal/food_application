package com.tamam.foodapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tamam.foodapplication.R
import com.tamam.foodapplication.model.Foods

class FoodsAdapter(private val listFoods: ArrayList<Foods>) : RecyclerView.Adapter<FoodsAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name_foods: TextView = itemView.findViewById(R.id.name_foods)
        val poster_path_foods: ImageView = itemView.findViewById(R.id.poster_path_foods)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dataFoods = listFoods[position]

        Glide.with(holder.itemView).load(dataFoods.posterPath).apply(RequestOptions().override(55, 55)).into(holder.poster_path_foods)
        holder.name_foods.text = dataFoods.name
        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, MovieDetailActivity::class.java)
//            intent.putExtra("id", dataFoods.id)
//            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listFoods.size

    fun setData(data: List<Foods>) {
        listFoods.clear()
        listFoods.addAll(data)
        notifyDataSetChanged()
    }
}