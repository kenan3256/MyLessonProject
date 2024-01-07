package com.kenanhaciyev.mylessonproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

class NotesFragment : Fragment() {
    //private val navArgs: NotesFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//       println("title: ${navArgs.title}")
//       print(navArgs.description)

        arguments?.getString("title")

        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    }
