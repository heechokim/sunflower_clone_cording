package com.example.sunflowerclone.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunflowerclone.Fragment1
import com.example.sunflowerclone.Fragment2

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        if(position == 0) {
            return Fragment1()
        }else{
            return Fragment2()
        }
        //return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}