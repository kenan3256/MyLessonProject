package com.kenanhaciyev.mylessonproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivtyViewModel : ViewModel() {
    var name = MutableLiveData<String>()
    var surname = MutableLiveData<String>()
    var clas = MutableLiveData<String>()
    var fullData = MutableLiveData<String>()

    fun updateFullData(name: String, surname: String, clas: String) {
        this.name.postValue(name)
        this.surname.postValue(surname)
        this.clas.postValue(clas)
    }

    fun getFulldata() {
        fullData.postValue("${this.name.value} ${this.surname.value} ${this.clas.value}")
    }
}

