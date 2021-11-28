package com.example.fakenews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.databinding.ActivityMainBinding
import com.example.fakenews.presentation.fragments.NewsPlace

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(binding.placeFragment.id, NewsPlace.newInstance())
            .commit()
    }
}