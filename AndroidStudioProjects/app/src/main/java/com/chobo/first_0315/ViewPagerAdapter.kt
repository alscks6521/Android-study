package com.chobo.first_0315

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        FirstFragment(),
        SecondFragment(),
    )

    // getItemCount()는 Fragment의 총 개수를 알려주는 역할
    override fun getItemCount(): Int {
       return  fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return  fragments[position]
    }
}