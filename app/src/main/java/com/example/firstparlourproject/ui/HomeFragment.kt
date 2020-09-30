package com.example.firstparlourproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.firstparlourproject.OfferFragment
import com.example.firstparlourproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val bottomNavigationView = view?.findViewById(R.id.bottomNavigationView) as BottomNavigationView
        val navController = findNavController()
        bottomNavigationView.setupWithNavController(navController)


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}