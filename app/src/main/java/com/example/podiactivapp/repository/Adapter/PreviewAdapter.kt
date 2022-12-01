package com.example.podiactivapp.repository.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.podiactivapp.R
import com.example.podiactivapp.ui.retrieveList
import com.squareup.picasso.Picasso

class PreviewAdapter: RecyclerView.Adapter<PreviewAdapter.ImageViewHolder>() {

    private lateinit var mListener:onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewAdapter.ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.preview_item,
            parent, false
        )
        return ImageViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: PreviewAdapter.ImageViewHolder, position: Int) {
        val currentItem = retrieveList[position]
        Picasso.get().load(currentItem).into(holder.imageThreeDim)
    }

    override fun getItemCount(): Int {
        return retrieveList.size
    }

    class ImageViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val imageThreeDim: ImageView = itemView.findViewById(R.id.imageView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}