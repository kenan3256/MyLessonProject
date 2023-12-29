package com.kenanhaciyev.mylessonproject

import android.app.SearchManager.OnCancelListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.kenanhaciyev.mylessonproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    var name = MutableLiveData<String>()
    var surname = MutableLiveData<String>()
    var clas = MutableLiveData<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner=this

        binding.adi = this
        binding.soyadi = this
        binding.sinifi = this

        binding.btnDaxilet.setOnClickListener {
            name.postValue("Kenan")
            surname.postValue("Haciyev")
            clas.postValue("9s")
        }


    }

}


