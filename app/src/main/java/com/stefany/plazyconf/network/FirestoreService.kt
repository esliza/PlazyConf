package com.stefany.plazyconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.stefany.plazyconf.model.Conference
import com.stefany.plazyconf.model.Speaker

const val CONFERENCES_COLLECTION_NAME  = "conferences"
const val SPEAKERS_COLLECTION_NAME  = "speakers"


class FirestoreService {


    val firebaseFireStore = FirebaseFirestore.getInstance()
    val setting=FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build() //persientcnia aunque no tengamos internet
    init {
        firebaseFireStore.firestoreSettings=setting
    }
    //funcion que trae los speakers de firebase
    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFireStore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result->
                for (doc in result){
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    //funcion que trae las conferencias de firebase
    fun getSchedule(callback: Callback<List<Conference>>){
        firebaseFireStore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result->
                for (doc in result){
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}