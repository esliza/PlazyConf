package com.stefany.plazyconf.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stefany.plazyconf.R
import com.stefany.plazyconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_shedule_detail.*
import kotlinx.android.synthetic.main.fragment_speakers_detail.*
import kotlinx.android.synthetic.main.item_scheadule.*


class SpeakersDetailFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.FullScreenDialogStyle)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarSpeakers.navigationIcon = ContextCompat.getDrawable(view.context,R.drawable.ic_close)
        toolbarSpeakers.setTitleTextColor(Color.WHITE)
        toolbarSpeakers.setNavigationOnClickListener{
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker
        toolbarSpeakers.title=speaker.name

        itemSpeackerName.text=speaker.name
        itemDetailSpeackearJob.text=speaker.jobtitle
        itemDetailSpeackerworklace.text = speaker.workplace
        itemDetailConferencebiography.text=speaker.biography
        Glide.with(view)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivspeaker)
        Glide.with(view)
            .load(speaker.twitter)
            .apply(RequestOptions.circleCropTransform())
            .into(itemDetailSpeackerTwitter)


    }
    private fun goToTwitter(nickname: String) {
        val openURL = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://twitter.com/$nickname")
        }
        startActivity(openURL)
    }

}