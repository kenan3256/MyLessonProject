package com.kenanhaciyev.mylessonproject.fetures.NewNotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddNotesViewModel:ViewModel() {
    var title = MutableLiveData<String>()
    var description = MutableLiveData<String>()
//    var fullData = MutableLiveData<String>()


    var newNoteCallback = MutableLiveData<Boolean>()
    var errorDescription = MutableLiveData<String>()

//    fun addNewNotes(title:String,description:String){
//        this.title.postValue(title)
//        this.description.postValue(description)
//    }
//
//    fun getFullData(){
//        fullData.postValue("${this.title.value} ${this.description.value}")
//    }


    fun onNewNotesInsert() {
        if (title.value.isNullOrEmpty() || description.value.isNullOrEmpty()) {
            errorDescription.postValue("Xanalari  doldurun!!!")
            return
        }
        newNoteCallback.postValue(true)
    }


}