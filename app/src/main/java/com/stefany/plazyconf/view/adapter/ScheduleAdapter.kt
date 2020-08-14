package com.stefany.plazyconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stefany.plazyconf.R
import com.stefany.plazyconf.model.Conference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener : ScheduleListener) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){

    var listConference=ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_scheadule, parent, false)) //reutilizar una vista

    override fun getItemCount() = listConference.size //entregar la cantida

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text=conference.title
        holder.tvConferenceSpeaker.text=conference.speaker
        holder.tvConferenceTag.text=conference.tag

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")
        val cal = Calendar.getInstance()
        cal.time = conference.datetime
        val hourformat = simpleDateFormat.format(conference.datetime)
        holder.tvConferenceHour.text = hourformat
        holder.tvConferenceAMPM.text = simpleDateFormatAMPM.format(conference.datetime).toUpperCase()

        holder.itemView.setOnClickListener{
            scheduleListener.onConferenceClicked(conference,position)
        }
    }

    fun updateData(data : List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheaduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheaduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheaduleTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvitemScheaduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvitemScheaduleAMPM)

    }

}