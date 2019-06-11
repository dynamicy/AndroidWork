package com.example.horizonrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.horizonrecyclerview.R
import com.example.horizonrecyclerview.model.Version

class MyAdapter(private val versionList: ArrayList<Version>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(versionList[position])

        holder.itemView.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                // run scale animation and make it bigger
                val anim = AnimationUtils.loadAnimation(view.context, R.anim.scale_in_tv)
                holder.itemView.startAnimation(anim)
                anim.fillAfter = true
            } else {
                // run scale animation and make it smaller
                val anim = AnimationUtils.loadAnimation(view.context, R.anim.scale_out_tv)
                holder.itemView.startAnimation(anim)
                anim.fillAfter = true
            }
        }
    }

    override fun getItemCount(): Int {
        return versionList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(version: Version) {
            val textView = itemView.findViewById<TextView>(R.id.tvName)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)
            textView.text = version.name

            Glide.with(itemView.context).load(version.url).into(imageView)
        }
    }
}