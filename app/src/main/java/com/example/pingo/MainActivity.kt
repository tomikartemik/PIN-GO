package com.example.pingo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pingo.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
lateinit var pref: SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = getSharedPreferences("bd", MODE_PRIVATE)

        supportFragmentManager.beginTransaction().replace(R.id.frame, MapsFragment.newInstance()).commit()
        binding.btn.visibility = View.VISIBLE
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.map -> {
                    supportFragmentManager.beginTransaction().replace(
                    R.id.frame,
                    MapsFragment.newInstance()
                    ).commit()
                    binding.btn.visibility = View.VISIBLE
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                    R.id.frame,
                    ProfileFragment.newInstance()
                    ).commit()
                    binding.btn.visibility = View.GONE
                }
                R.id.settings -> {
                    supportFragmentManager.beginTransaction().replace(
                    R.id.frame,
                    SettingsFragment.newInstance()
                    ).commit()
                    binding.btn.visibility = View.GONE
                }
            }
            true
        }
        binding.btn.setOnClickListener{
//            val creator = pref.edit()
//            creator.putBoolean("Loc", true)
//            creator.apply()
            binding.editTextTextPersonName.visibility = View.VISIBLE
            binding.imageButton.visibility = View.VISIBLE
    }
        binding.imageButton.setOnClickListener {
            binding.editTextTextPersonName.visibility = View.GONE
            binding.imageButton.visibility = View.GONE
            binding.label.visibility = View.VISIBLE
        }
    }
}