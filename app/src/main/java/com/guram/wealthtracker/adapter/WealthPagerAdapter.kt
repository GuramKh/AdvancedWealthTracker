package com.guram.wealthtracker.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.guram.wealthtracker.fragments.AnalyticsFragment
import com.guram.wealthtracker.fragments.InputFragment
import com.guram.wealthtracker.fragments.ProfileFragment

class WealthPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0    -> InputFragment()
        1    -> AnalyticsFragment()
        2    -> ProfileFragment()
        else -> InputFragment()
    }
}
