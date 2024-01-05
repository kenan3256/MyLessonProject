package com.kenanhaciyev.mylessonproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivtyViewModel : ViewModel() {


    var addNotesObserver = MutableLiveData<Boolean>()


    fun onAddNewNotes() {
        addNotesObserver.postValue(true)
    }


}

