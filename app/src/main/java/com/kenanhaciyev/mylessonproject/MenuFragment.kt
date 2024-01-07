package com.kenanhaciyev.mylessonproject

import android.app.DirectAction
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kenanhaciyev.mylessonproject.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
lateinit var binding:FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun openNotesPage(){
       // val action = MenuFragmentDirections.actionMenuToNotes("YAnva","31 yanvar") //back steck fragment
        val action = MenuFragmentDirections.actionMenuToNotesDetail()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentMenuBinding.inflate(layoutInflater)
        binding.notesButton.setOnClickListener {
            openNotesPage()
        }
        return binding.root

    }


}