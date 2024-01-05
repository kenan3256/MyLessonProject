package com.kenanhaciyev.mylessonproject.fetures.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivtyViewModel : ViewModel() {


    var addNotesObserver = MutableLiveData<Boolean>()


    fun onAddNewNotes() {
        addNotesObserver.postValue(true)
    }


}

