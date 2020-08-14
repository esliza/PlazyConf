package com.stefany.plazyconf.view.adapter

import com.stefany.plazyconf.model.Speaker

interface SpeakerListener{
    fun onSpeakerClicked(speaker: Speaker, position:Int){

    }
}