package com.kenanhaciyev.mylessonproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.kenanhaciyev.mylessonproject.databinding.ActivityMainBinding
import com.kenanhaciyev.mylessonproject.fetures.model.Notes
import com.kenanhaciyev.mylessonproject.fetures.NewNotes.AddNotesActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainActivtyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainActivtyViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)
    }

    fun openAddStudentActivity() {
        val intent = Intent(this, AddNotesActivity::class.java)
        newNotesLouncher.launch(intent)
    }

    val newNotesLouncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resualt ->
            if (resualt.resultCode == Activity.RESULT_OK) {
                val item = resualt.data?.getParcelableExtra<Notes>("notes")
            println(item)
            }
        }

    fun observerAll() {
        viewModel.addNotesObserver.observe(this) {
            if (it) {
                openAddStudentActivity()
            }

        }


    }

    fun removeObserverAll() {
        viewModel.addNotesObserver.removeObservers(this)
        viewModel.addNotesObserver.postValue(false)
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


