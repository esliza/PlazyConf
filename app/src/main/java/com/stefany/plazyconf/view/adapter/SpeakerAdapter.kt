package com.stefany.plazyconf.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stefany.plazyconf.R
import com.stefany.plazyconf.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener):RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listSpeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_speacker,parent,false))

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {

        val speaker =listSpeakers[position] as Speaker
        holder.tvSpeakerName.text= speaker.name
        holder.tvSpeakerJob.text = speaker.jobtitle

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.tvSpeakerPhoto)


        holder.itemView.setOnClickListener{
            speakerListener.onSpeakerClicked(speaker,position)
        }

    }

    fun updateDate(data : List<Speaker>){
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvitemSpeakerName)
        val tvSpeakerJob = itemView.findViewById<TextView>(R.id.tvitemSpeakerJob)
        val tvSpeakerPhoto = itemView.findViewById<ImageView>(R.id.imgitemSpeakerPhoto)

    }

}