package com.stefany.plazyconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stefany.plazyconf.model.Speaker
import com.stefany.plazyconf.network.Callback
import com.stefany.plazyconf.network.FirestoreService
import java.lang.Exception

class SpeakersViewModel :ViewModel() {
    val firestoreService= FirestoreService()
    var listSpeakers:MutableLiveData<List<Speaker>> = MutableLiveData()
    var isloading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object: Callback<List<Speaker>> {
            override fun onFailet(exception: Exception) {
                processFinish()
            }

            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinish()
            }
        })
    }

    fun processFinish() {
        isloading.value=true
    }


}