package com.stefany.plazyconf.view.adapter

import com.stefany.plazyconf.model.Conference

interface ScheduleListener{
    fun onConferenceClicked(conference: Conference, position: Int){

    }
}