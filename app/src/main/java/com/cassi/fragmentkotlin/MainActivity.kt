package com.cassi.fragmentkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.Fragment
import com.cassi.fragmentkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFragment1.setOnClickListener {
            goToFragment(Fragment1())
        }

        binding.buttonFragment2.setOnClickListener {
            goToFragment(Fragment2())
        }
    }

    private fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentcontainer, fragment).commit()
    }

}