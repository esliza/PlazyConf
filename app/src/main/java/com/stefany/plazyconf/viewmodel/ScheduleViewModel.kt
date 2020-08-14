package com.stefany.plazyconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stefany.plazyconf.model.Conference
import com.stefany.plazyconf.network.Callback
import com.stefany.plazyconf.network.FirestoreService
import java.lang.Exception

class ScheduleViewModel : ViewModel(){
    var firestoreService=FirestoreService()
    var listSchedule:MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase() {
       firestoreService.getSchedule(object: Callback<List<Conference>>{
           override fun onSuccess(result: List<Conference>?) {
               listSchedule.postValue(result)
               proccessFinish()
           }

           override fun onFailet(exception: Exception) {
               proccessFinish()
           }

       })
    }

    private fun proccessFinish() {
        isLoading.value = true
        //cuando termina el proceso de carga
    }
}