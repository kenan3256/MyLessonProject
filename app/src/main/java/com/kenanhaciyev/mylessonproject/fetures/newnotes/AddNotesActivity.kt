package com.kenanhaciyev.mylessonproject.fetures.newnotes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kenanhaciyev.mylessonproject.fetures.model.Notes
import com.kenanhaciyev.mylessonproject.databinding.ActivityAddNotesBinding


class AddNotesActivity: AppCompatActivity() {

    lateinit var binding:ActivityAddNotesBinding
    lateinit var viewModel: AddNotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddNotesViewModel::class.java)

        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }
    fun observerAll() {
        viewModel.newNoteCallback.observe(this){
            val intent = Intent()
            val notes = Notes("Yanvar", "ise get")
            intent.putExtra("notes", notes)
            setResult(RESULT_OK, intent )
            finish()

        }
        viewModel.errorDescription.observe(this){
            if (!it.isNullOrEmpty()){
                Toast.makeText(this,it, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun removeObserverAll() {
        viewModel.newNoteCallback.removeObservers(this)
        viewModel.newNoteCallback.postValue(false)
    }

    override fun onResume() {
        super.onResume()
        observerAll()
    }

    override fun onPause() {
        super.onPause()
        removeObserverAll()
    }


}