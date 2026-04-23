package com.guram.wealthtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.guram.wealthtracker.adapter.WealthPagerAdapter
import com.guram.wealthtracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gkLiViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        val adapter = WealthPagerAdapter(this)
        binding.gkLiViewPager.adapter = adapter

        val tabTitles = listOf("Input", "Analytics", "Profile")

        TabLayoutMediator(binding.gkLiTabLayout, binding.gkLiViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
