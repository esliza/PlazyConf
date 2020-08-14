package com.stefany.plazyconf.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.stefany.plazyconf.R
import com.stefany.plazyconf.model.Conference
import kotlinx.android.synthetic.main.fragment_shedule_detail.*
import java.text.SimpleDateFormat
import java.util.*

class SheduleDetailFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shedule_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarConference.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarConference.setTitleTextColor(Color.WHITE)
        toolbarConference.setNavigationOnClickListener {
            dismiss()
        }

        val conference = arguments?.getSerializable("conference") as Conference
        toolbarConference.title = conference.title

        tvItemScheduleTituloConferencia.text=conference.title
        val pattern="dd/MM/yy hh:mm a"
        val simpleDF = SimpleDateFormat(pattern)
        val date =simpleDF.format(conference.datetime)
        itemDetailConferenceHour.text= date
        itemDetailConferenceSpeacker.text=conference.speaker
        itemDetailConferenceTag.text=conference.tag
        itemDetailConferenceDescription.text=conference.descripcion

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT )
    }
}