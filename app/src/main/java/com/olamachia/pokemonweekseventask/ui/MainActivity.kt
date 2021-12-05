package com.olamachia.pokemonweekseventask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.olamachia.pokemonweekseventask.R
import com.olamachia.pokemonweekseventask.databinding.ActivityMainBinding
import com.olamachia.pokemonweekseventask.ui.fragments.PokemonSearchFragment
import com.olamachia.pokemonweekseventask.ui.fragments.UploadImageFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        /* Initializing the Fragments */

        /* When we click on a particular nav-bar item, the listener sets it to the corresponding fragment */


        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId) {
                R.id.search_icon_navbar -> {setCurrentFragment(PokemonSearchFragment())
                    Log.d("clicked", R.id.search_icon_navbar.toString())
                    true}
                R.id.upload_image_navbar -> {setCurrentFragment(UploadImageFragment())
                    Log.d("clicked", R.id.search_icon_navbar.toString())
                    true }
                else -> {
                    Log.d("clicked", R.id.search_icon_navbar.toString())
                    true}
            }
        }

        setCurrentFragment(PokemonSearchFragment())

        }


    /* Sets the current fragment on the container in the Activity */
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().
            replace(R.id.fragment_container,fragment).
            commit()

}