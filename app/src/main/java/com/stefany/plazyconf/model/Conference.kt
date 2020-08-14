package com.stefany.plazyconf.model

import java.io.Serializable
import java.util.*
//serealizable puede pasar objetos entre activities

class Conference :Serializable {
    lateinit var title:String
    lateinit var descripcion:String
    lateinit var tag:String
    lateinit var datetime:Date
    lateinit var speaker: String
}