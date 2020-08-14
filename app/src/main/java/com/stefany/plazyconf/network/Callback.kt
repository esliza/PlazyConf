package com.stefany.plazyconf.network

import java.lang.Exception


interface Callback<T>{

    fun onSuccess(result: T?)
    fun onFailet(exception: Exception)

}