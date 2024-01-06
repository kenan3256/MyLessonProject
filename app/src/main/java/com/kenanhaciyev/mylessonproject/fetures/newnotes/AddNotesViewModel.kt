package com.kenanhaciyev.mylessonproject.fetures.newnotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kenanhaciyev.mylessonproject.fetures.model.Notes

class AddNotesViewModel:ViewModel() {
    var title = MutableLiveData<String>()
    var description = MutableLiveData<String>()



    var newNoteCallback = MutableLiveData<Boolean>()
    var errorDescription = MutableLiveData<String>()

fun createAddNewNotes() : Notes {
    return Notes(0, title.value?:"Bos", description.value?: "Bos")
    //burda yeni not yaradacaq bir metod yazdiq ve ilkin deyerlerinide bos verdik
}


    fun onNewNotesInsert() {
        if (title.value.isNullOrEmpty() || description.value.isNullOrEmpty()) {
            errorDescription.postValue("Xanalari  doldurun!!!")
            return
        }
        newNoteCallback.postValue(true)
    }


}